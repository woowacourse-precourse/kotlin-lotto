package lotto.input

class PayedMoney() {
    private val userInputNumber= lotto.util.input().inputUser()
    fun inputUserMoney(): String {
        println("구입금액을 입력해 주세요.")
        checkMoneyStandard(userInputNumber)
        println(userInputNumber.replace("000", "")+"개를 구매했습니다.")
        return userInputNumber.replace("000", "")
    }

    fun checkMoneyStandard(userInputNumber: String?) {
        userInputNumber ?: throw IllegalArgumentException("[ERROR]")
        val checkMoney = userInputNumber.split(",").toList() as MutableList<String>
        lotto.util.InputValidable().checkInputMessagePatten(checkMoney)
        println(userInputNumber.toInt())
        if (userInputNumber.toInt() % 1000 != 0 || userInputNumber.toInt() == 0) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}