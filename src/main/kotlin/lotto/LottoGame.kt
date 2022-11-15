package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

const val LOTTO_PRICE = 1_000
const val PERCENT = 100
const val ROUND_DIGITS = 10

class LottoGame {
    fun start() {
        try {
            val lottoCount = generateLottoCount()
            val winningNumbers = generateWinningNumbers()
            val bonusNumber = generateBonusNumber(winningNumbers)
            val lotteries = generateLotteries(lottoCount)

            for (lotto in lotteries) {
                checkLottoWin(lotto, winningNumbers, bonusNumber)
            }
            showResult(lottoCount)
        } catch (e: IllegalArgumentException) {

        }
    }

    private fun generateLottoCount(): Int {
        println("구입금액을 입력해 주세요.")
        val money = Console.readLine()
        MoneyCheckError(money).checkMoneyThrowException()
        val lottoCount = money.toInt() / LOTTO_PRICE
        println("${lottoCount}개를 구매했습니다.")
        return lottoCount
    }

    private fun generateWinningNumbers(): Lotto {
        println("당첨 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        WinningNumberCheckError(userInput).throwWinningNumberFormException()
        val winningNumbers = convertStringToIntList(userInput)
        return Lotto(winningNumbers)
    }

    private fun convertStringToIntList(userInput: String): List<Int> {
        return userInput.split(',').map { it.toInt() }
    }

    private fun generateBonusNumber(winningNumbers: Lotto): BonusNumber {
        println("보너스 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        return BonusNumber(userInput, winningNumbers)
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    private fun generateLotteries(lottoCount: Int): List<Lotto> {
        val lotteries = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lotto = generateLotto()
            lotto.print()
            lotteries.add(lotto)
        }
        return lotteries
    }

    private fun checkLottoWin(lotto: Lotto, winningNumbers: Lotto, bonusNumber: BonusNumber) {
        var count = 0
        for (number in lotto.getNumbers()) {
            if (winningNumbers.isContainedNumber(number)) count++
        }

        when {
            count == 3 -> Result.FIFTH.addWinCount()
            count == 4 -> Result.FOURTH.addWinCount()
            count == 5 && !lotto.isContainedNumber(bonusNumber) -> Result.THIRD.addWinCount()
            count == 5 && lotto.isContainedNumber(bonusNumber) -> Result.SECOND.addWinCount()
            count == 6 -> Result.FIRST.addWinCount()
        }
    }

    private fun showResult(lottoCount: Int) {
        println("당첨 통계\n---")
        val resultList = listOf(Result.FIFTH, Result.FOURTH, Result.THIRD, Result.SECOND, Result.FIRST)
        resultList.forEach { result -> result.print() }
        println("총 수익률은 ${calculateEarningsRate(lottoCount, resultList)}%입니다.")
    }

    private fun calculateEarningsRate(lottoCount: Int, resultList: List<Result>): Double {
        var totalEarning = 0
        resultList.forEach { result -> totalEarning += result.getEarningRate() }
        val earningRate = totalEarning / (lottoCount.toDouble() * LOTTO_PRICE) * PERCENT
        return roundEarningRate(earningRate)
    }

    private fun roundEarningRate(earningRate: Double) = round(earningRate * ROUND_DIGITS) / ROUND_DIGITS
}
