package lotto

class WinningNumber {
    fun getWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val input = readLine()?.split(',')

        checkWinningNumberException(input)

        return changeIntList(input)
    }

    private fun checkWinningNumberException(input: List<String>?) {
        checkSize(input)
        checkNumberFormat(input)
        checkNumberRange(input)
        checkDuplication(input)
    }

    private fun checkSize(input: List<String>?) {
        require(input?.size == 6) {
            "[ERROR] 숫자 6개를 입력해야 합니다."
        }
    }

    private fun checkNumberFormat(input: List<String>?) {
        try {
            input?.forEach { it ->
                it.toInt()
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자 형식으로 입력해야 합니다.")
        }
    }

    private fun checkNumberRange(input: List<String>?) {
        val inputNumber = changeIntList(input)

        inputNumber.forEach { it ->
            require(it in 1..45) {
                "[ERROR] 1~45까지의 숫자로 입력해야 합니다."
            }
        }
    }

    private fun checkDuplication(input: List<String>?) {
        require(input?.distinct() == input) {
            "[ERROR] 중복되는 숫자가 없어야 합니다."
        }
    }

    private fun changeIntList(input: List<String>?): List<Int> {
        val inputNumber = mutableListOf<Int>()

        input?.forEach { it ->
            inputNumber.add(it.toInt())
        }

        return inputNumber
    }
}