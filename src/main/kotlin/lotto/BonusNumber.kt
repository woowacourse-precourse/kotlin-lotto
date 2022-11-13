package lotto

class BonusNumber {
    fun getBonusNumber(winningNumber: List<Int>): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = readLine()

        checkBonusNumberException(input, winningNumber)

        return input?.toInt() ?: 0
    }

    private fun checkBonusNumberException(input: String?, winningNumber: List<Int>) {
        checkNumberFormat(input)
        checkNumberRange(input)
        checkDuplication(input, winningNumber)
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

    private fun checkDuplication(input: String?, winningNumber: List<Int>) {
        require(!winningNumber.contains(input?.toInt())) {
            "[ERROR] 당첨 번호와 중복되는 숫자가 없어야 합니다."
        }
    }
}