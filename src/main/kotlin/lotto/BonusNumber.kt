package lotto

class BonusNumber {
    fun getBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = readLine()

        checkBonusNumberException(input)

        return input?.toInt() ?: 0
    }

    private fun checkBonusNumberException(input: String?) {
        checkNumberFormat(input)
        checkNumberRange(input)
    }

    private fun checkNumberFormat(input: String?) {
        try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자 형식으로 입력해야 합니다.")
        }
    }

    private fun checkNumberRange(input: String?) {
        val inputToNumber = input?.toInt()

        require(inputToNumber in 1..45) {
            "[ERROR] 1~45까지의 숫자로 입력해야 합니다."
        }
    }
}