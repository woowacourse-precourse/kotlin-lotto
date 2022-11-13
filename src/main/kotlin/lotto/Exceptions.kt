package lotto

object Exceptions {
    fun checkMoney(money: String) {
        if (money.any { it !in '0'..'9' }) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
        }
        if ((money.toInt() % 1000) != 0) {
            throw IllegalArgumentException("[ERROR] 1000 단위로 입력해야 합니다.")
        }
        if (money.toInt() < 1000) {
            throw IllegalArgumentException("[ERROR] 1000 이상 입력해야 합니다.")
        }
    }
}