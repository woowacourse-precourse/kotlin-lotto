package lotto.domain

import camp.nextstep.edu.missionutils.Console
import util.Exceptions
import util.Messages
import util.Printers

class LottoMachine(
    private val lotteries: List<Lotto>
) {

    private var winningNumber = mutableListOf<Int>()
    private var bonus = 0

    fun setWinningAndBonusNumber() {
        winningNumber = inputWinningNumber().toMutableList()
        bonus = inputBonusNumber()
    }

    fun compareNumber(): List<Int> {
        val result = mutableListOf(0, 0, 0, 0, 0)
        lotteries.forEach { lotto ->
            when (resultOfLotto(lotto)) {
                Rating.SIX -> result[0]++
                Rating.FIVE -> result[1]++
                Rating.FIVE_AND_BONUS -> result[2]++
                Rating.FOUR -> result[3]++
                Rating.THREE -> result[4]++
                else -> Unit
            }
        }
        return result.toList()
    }

    // 수익률은 소수점 둘째 자리에서 반올림
    fun yieldLottoResult(money: String): String {
        val rate = rateLottoResult(money)
        return String.format(String.format("%.1f", rate))
    }

    // 로또의 수익률
    private fun rateLottoResult(money: String): Double {
        val result = compareNumber()
        val prize = mutableListOf(
            Rating.SIX.winningAmount,
            Rating.FIVE.winningAmount,
            Rating.FIVE_AND_BONUS.winningAmount,
            Rating.FOUR.winningAmount,
            Rating.THREE.winningAmount
        )
        return (sumOfWinningMoney(result, prize) / money.toDouble()) * 100
    }

    private fun sumOfWinningMoney(result: List<Int>, prize: MutableList<Int>): Double {
        var sumOfWinningMoney = 0.0
        for (index in result.indices) {
            sumOfWinningMoney += result[index] * prize[index]
        }
        return sumOfWinningMoney
    }


    // 로또의 번호 매칭 결과
    private fun resultOfLotto(lotto: Lotto): Rating {
        var matches = 0
        var bonusMatch = false
        val userLotto = lotto.getOrderedNumbers()
        userLotto.forEach { number ->
            if (winningNumber.contains(number)) matches++
            if (number == bonus) bonusMatch = true
        }
        return Rating.lottoResult(matches, bonusMatch)
    }

    private fun inputWinningNumber(): List<Int> {
        Printers.inputWinningNumber()
        val number = Console.readLine()
        val numberSplit = number.split(',')
        // 당첨번호 예외 확인
        Exceptions.run {
            val winningNumber = isValidWinningNumber(numberSplit)
            isValidRangeWinningNumber(winningNumber)
            require(winningNumber.size == 6) {
                throw IllegalArgumentException(Messages.ERROR_LOTTO_SIZE)
            }
            hasDuplicateNumbers(winningNumber)
        }
        Printers.nextLine()
        return numberSplit.map { it.toInt() }
    }

    private fun inputBonusNumber(): Int {
        Printers.inputBonusNumber()
        val bonus = Console.readLine()
        Exceptions.run {
            bonus.isValidBonusNumber()
            bonus.toInt().isValidRangeBonusNumber()
            bonus.toInt().isUniqueBonusNumber(winningNumber)
        }
        Printers.nextLine()
        return bonus.toInt()
    }

    // 구매한 로또 리스트 출력
    fun checkList() {
        Printers.lottoList(lotteries)
    }
}