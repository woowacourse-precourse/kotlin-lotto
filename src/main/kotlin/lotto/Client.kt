package lotto
import camp.nextstep.edu.missionutils.Console.readLine

class Client {
    private val rule = Rule()
    var purchaseAmount = 0

    fun inputPurchaseAmount() {
        val input = readLine()
        rule.checkPurchaseAmount(input)
        this.purchaseAmount = input.toInt()
    }
}