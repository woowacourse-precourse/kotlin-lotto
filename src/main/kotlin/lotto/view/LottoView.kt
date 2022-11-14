package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lottos
import lotto.domain.Ranking
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.LinkedHashMap

class LottoView {

    fun getInputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine()
        validMoneyMount(inputMoney)
        return inputMoney.toInt()
    }

    private fun validMoneyMount(inputMoney: String) {
        if (!isNumber(inputMoney)) {
            throw IllegalArgumentException("[ERROR]: 1,000원 단위의 숫자로만 입력되어야 합니다.")
        }
    }

    fun printIssuedLottos(lottos: Lottos, issuedNumberOfLotto: Int) {
        println("\n${issuedNumberOfLotto}개를 구매했습니다.")
        val issuedLottoList = lottos.getLottosList()
        for (lotto in issuedLottoList) {
            println(lotto.getLottoNumberList())
        }
    }

    fun getWinningLotto(): List<Int> {
        val WinningLottoNumbers = mutableListOf<Int>()
        println("당첨 번호를 입력해 주세요.")
        val inputWinningLottoNumbers = Console.readLine()
        val list = inputWinningLottoNumbers.split(",")
        validWinningLotto(list)
        for (eachLottoNumber in list) {
            WinningLottoNumbers.add(eachLottoNumber.toInt())
        }
        return WinningLottoNumbers
    }

    private fun validWinningLotto(lottoNumList: List<String>) {
        for (lottoNum in lottoNumList) {
            if (!isNumber(lottoNum) || !isValidNumberRange(lottoNum.toInt())) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun getBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val inputBonusNumber = Console.readLine()
        if (!isNumber(inputBonusNumber) || !isValidNumberRange(inputBonusNumber.toInt())) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return inputBonusNumber.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidNumberRange(bonusNumber: Int): Boolean {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return true
    }

    fun printResult(lottoResult: MutableMap<Ranking, Int>) {
        println("\n당첨 통계")
        println("---")
        val entries = LinkedList(lottoResult.entries)
        entries.reverse()
        val result = LinkedHashMap<Ranking, Int>()
        for (entry in entries) {
            result[entry.key] = entry.value
        }
        for (i in result) {
            printWinningReward(i.key, i.value)
        }
    }

    private fun printWinningReward(reward: Ranking, numOfRightLotto: Int) {
        val moneyPrintFormat = DecimalFormat("#,###")
        if (reward == Ranking.FAIL) {
            return
        }

        if (reward.matchBonusNumber) {
            println("${reward.count}개 일치, 보너스 볼 일치 (" + moneyPrintFormat.format(reward.prize) + "원) - " + numOfRightLotto + "개")
            return
        }

        println("${reward.count}개 일치 (" + moneyPrintFormat.format(reward.prize) + "원) - " + numOfRightLotto + "개")
    }

    fun printYieldRate(inputMoney: Int, lottoResult: MutableMap<Ranking, Int>) {
        val totalAmount = calculateEarningAmount(lottoResult)
        val earningRate = (totalAmount / inputMoney.toDouble()) * YIELD_RATE_PERCENTAGE
        println("총 수익률은 ${String.format("%.1f",earningRate)}%입니다.")
    }

    private fun calculateEarningAmount(lottoResult: MutableMap<Ranking, Int>): Int {
        var totalAmount = 0
        for (rank in lottoResult) {
            totalAmount += rank.key.prize * rank.value
        }
        return totalAmount
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
        const val YIELD_RATE_PERCENTAGE = 100
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}