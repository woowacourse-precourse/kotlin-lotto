package lotto

class User {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val input = readLine()

        checkMoneyException(input)

        return input?.toInt() ?: 0
    }

    private fun checkMoneyException(input: String?) {
        checkNumberFormat(input)
        checkMoney(input)
    }

    private fun checkNumberFormat(input: String?) {
        try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자 형식으로 입력해야 합니다.")
        }
    }

    private fun checkMoney(input: String?) {
        val inputToInt = input?.toInt()
        if (inputToInt != null) {
            require(inputToInt % 1000 == 0 && inputToInt != 0) {
                "[ERROR] 1000원 단위로 입력해야 합니다."
            }
        }
    }
}