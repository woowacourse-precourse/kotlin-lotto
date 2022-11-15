package exception

class LottoPurchase(amount: String) {
    private val regex = "^[0-9]*\$".toRegex()

    init {
        require(amount.matches(regex)) {
            "[ERROR] 구입 금액은 숫자로만 입력해야 합니다."
        }
        require(amount.toInt() % 1000 == 0) {
            "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다."
        }
    }
}