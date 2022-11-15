package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import utils.Constants
import utils.Constants.ERROR_NOT_1000WON_MESSAGE
import utils.Constants.ERROR_NOT_NUMBER_MESSAGE
import kotlin.system.exitProcess

class Client {
    private val rule = Rule()
    val lottos = mutableListOf<Lotto>()
    private var purchaseAmount = 0
    var purchaseCount = 0

    fun inputPurchaseAmount(): Int {
        val input = readLine()
        try {
            rule.checkPurchaseAmount(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return -1
        }

        this.purchaseAmount = input.toInt()
        this.purchaseCount = this.purchaseAmount / 1000
        return purchaseAmount
    }


    fun purchaseLotto(): List<Lotto> {
        for (i in 0 until this.purchaseCount) {
            val lotto = Lotto(makeLotto())
            lottos.add(lotto)
        }
        return lottos
    }

    private fun makeLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun inputWinningNumbers(statistics: LottoStatistics) {
        val input = readLine()
        val numbers = input.split(",")
        statistics.setWinningNumbers(numbers)
    }

    fun inputBonusNumber(statistics: LottoStatistics) {
        val input = readLine().toInt()
        statistics.setBonusNumber(input)
    }

}