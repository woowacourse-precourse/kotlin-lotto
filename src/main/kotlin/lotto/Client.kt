package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

class Client {
    private val rule = Rule()
    private val statistics = LottoStatistics()
    val lottos = mutableListOf<Lotto>()
    private var purchaseAmount = 0
    var purchaseCount = 0

    fun inputPurchaseAmount() {
        val input = readLine()
        rule.checkPurchaseAmount(input)

        this.purchaseAmount = input.toInt()
        this.purchaseCount = this.purchaseAmount / 1000
    }

    fun purchaseLotto() {
        for (i in 0 until this.purchaseCount) {
            val lotto = Lotto(makeLotto())
            lottos.add(lotto)
        }
    }

    private fun makeLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun inputWinningNumbers() {
        val input = readLine()
        val numbers = input.split(",")
        statistics.setWinningNumbers(numbers)
    }

    fun inputBonusNumber() {
        val input = readLine().toInt()
        statistics.setBonusNumber(input)
    }

}