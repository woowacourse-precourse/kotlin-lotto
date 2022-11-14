package lotto

const val LOTTO_PRICE = 1000

object Exceptions {
    fun checkMoney(money: String) {
        checkDigit(money)

        if ((money.toInt() % LOTTO_PRICE) != 0) {
            throw IllegalArgumentException("[ERROR] 1000 단위로 입력해야 합니다.")
        }
        if (money.toInt() < LOTTO_PRICE) {
            throw IllegalArgumentException("[ERROR] 로또 가격 이상 입력해야 합니다.")
        }
    }

    fun checkLotto(numbers: List<Int>) {
        checkRange(numbers, 45)

        check(numbers)
    }

    fun checkWiningNumber(winningNumber: List<String>) { //"1, 2, 3, 4, 5, 6"

        require(winningNumber.size == 6) { Message.ERROR_MASSAGE }

        winningNumber.forEach {
            checkDigit(it)
        }

        checkRange(winningNumber.map { it.toInt() }, 45)

        check(winningNumber.map { it.toInt() })
    }

    fun checkBonus(winningNumber: List<String>, bonus: String) {

        checkDigit(bonus)
        if (winningNumber.any { it == bonus }) {
            throw IllegalArgumentException("[ERROR] 당첨번호와 다른 숫자를 입력해야 합니다.")
        }
    }

    private fun checkDigit(string: String) {
        if (string.contains(Regex("\\D"))
        ) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
        }
    }

    private fun checkRange(intList: List<Int>, range: Int) {
        if (intList.any { it !in 1..range }) {
            throw IllegalArgumentException("[ERROR] 1 ~ 45사이 숫자를 입력해야 합니다.")
        }
    }

    private fun check(list: List<Int>) {
        if (list.toSet().size != list.size) {
            throw IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해야 합니다.")
        }
    }
}