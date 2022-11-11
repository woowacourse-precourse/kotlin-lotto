package lotto

class InputVerifier {
    fun validateAmountOfPurchase(amountOfPurchase: Int) {
        if (amountOfPurchase % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.")
        }
    }
}