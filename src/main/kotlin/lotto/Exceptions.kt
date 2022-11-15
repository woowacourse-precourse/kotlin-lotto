package lotto

object Exceptions {
    fun checkMoney(money: String) {
        checkDigit(money)

        if ((money.toInt() % LOTTO_PRICE) != 0) {
            throw IllegalArgumentException(Message.UNIT_ERROR)
        }
        if (money.toInt() < LOTTO_PRICE) {
            throw IllegalArgumentException(Message.MIN_VALUE_ERROR)
        }
    }

    fun checkLotto(numbers: List<Int>) {
        checkRange(numbers)

        checkSameDigit(numbers)
    }

    fun checkWiningNumber(winningNumber: List<String>) {

        require(winningNumber.size == LOTTO_SIZE) { Message.SIZE_ERROR }

        winningNumber.forEach {
            checkDigit(it)
        }

        checkRange(winningNumber.map { it.toInt() })

        checkSameDigit(winningNumber.map { it.toInt() })
    }

    fun checkBonus(winningNumber: List<String>, bonus: String) {

        checkDigit(bonus)
        if (winningNumber.any { it == bonus }) {
            throw IllegalArgumentException(Message.SAME_WINNING_NUMBER_ERROR)
        }
    }

    private fun checkDigit(string: String) {
        if (string.contains(Regex("\\D"))
        ) {
            throw IllegalArgumentException(Message.NOT_DIGIT_ERROR)
        }
    }

    private fun checkRange(intList: List<Int>) {
        if (intList.any { it !in MIN_VALUE..MAX_VALUE }) {
            throw IllegalArgumentException(Message.RANGE_ERROR)
        }
    }

    private fun checkSameDigit(list: List<Int>) {
        if (list.toSet().size != list.size) {
            throw IllegalArgumentException(Message.SAME_DIGIT_ERROR)
        }
    }
}