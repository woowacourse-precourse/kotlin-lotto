package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

class Client {
    private val rule = Rule()
    val purchaseLottos = mutableListOf<Lotto>()
    var purchaseCount = 0
    private var purchaseAmount = 0
    private var winningNumbers = mutableListOf<Int>()
    private var bonusNumber: Int = 0

    fun inputPurchaseAmount() {
        val input = readLine()
        rule.checkPurchaseAmount(input)

        this.purchaseAmount = input.toInt()
        this.purchaseCount = this.purchaseAmount / 1000
    }

    fun purchaseLotto() {
        for (i in 0 until this.purchaseCount) {
            val lotto = Lotto(makeLotto())
            purchaseLottos.add(lotto)
        }
    }

    private fun makeLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun inputWinningNumbers() {
        val input = readLine()
        val numbers = input.split(",")
        rule.checkWinningNumbers(numbers)

        for (number in numbers)
            this.winningNumbers.add(number.toInt())
    }

    fun inputBonusNumber() {
        val input = readLine().toInt()
        rule.checkBonusNumber(winningNumbers, input)

        this.bonusNumber = input
    }
}