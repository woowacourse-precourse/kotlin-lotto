package lotto.exception

class InputException {

    fun checkInputNumbersException(input: String?) {
        checkNullException(input)
        input?.split(",")?.let { this.checkTypeException(it) }
        val numbers = input?.split(",")?.map { it.toInt() }!!
        checkRangeException(numbers)
        checkOverlapException(numbers)
    }

    fun checkBonusException(input: String?) {
        checkNullException(input)
        checkTypeException(input)
        checkRangeException(input?.toInt()!!)
    }

    fun checkInputException(input: String?) {
        checkTypeException(input)
        inputMoneyException(input!!)
    }

    fun checkBonusException(numbers: List<Int>, bonus: Int) {
        if (numbers.contains(bonus))
            invalidException(OVERLAP_EXCEPTION)
    }

    private fun checkTypeException(input: String?) {
        try {
            input?.toInt()
        } catch (e: Exception) {
            invalidException(TYPE_EXCEPTION)
        }
    }

    private fun checkTypeException(input: List<String>) {
        try {
            input.map { it.toInt() }
        } catch (e: Exception) {
            invalidException(TYPE_EXCEPTION)
        }
    }

    private fun checkNullException(input: String?) {
        if (input.isNullOrEmpty()) {
            invalidException(NULL_EXCEPTION)
        }
    }

    private fun inputMoneyException(money: String) {
        if (money.toInt() % 1000 != 0) invalidException(VALUE_EXCEPTION)
    }

    private fun checkRangeException(numbers: List<Int>) {
        numbers.forEach { num ->
            if (num !in 1..45) invalidException(VALUE_EXCEPTION)
        }
    }

    private fun checkRangeException(number: Int) {
        if (number !in 1..45) invalidException(VALUE_EXCEPTION)
    }

    private fun checkOverlapException(numbers: List<Int>) {
        if (numbers.size != numbers.toSet().size)
            invalidException(OVERLAP_EXCEPTION)
        else if (numbers.size != 6)
            invalidException(LENGTH_EXCEPTION)
    }

    private fun invalidException(message: String) {
        println("[ERROR] : $message")
        throw IllegalArgumentException("[ERROR] : $message")
    }

    companion object {
        const val TYPE_EXCEPTION = "올바른 형식이 아닙니다."
        const val NULL_EXCEPTION = "아무 것도 입력하지 않았습니다."
        const val VALUE_EXCEPTION = "잘못된 값입니다."
        const val OVERLAP_EXCEPTION = "중복된 값이 존재 합니다."
        const val LENGTH_EXCEPTION = "6개 입력이 아닙니다."
    }
}