package lotto

object ExceptionHandler {
    private const val PURCHASING_AMOUNT_EXCEPTION = "[ERROR] 구입금액이 올바르지 않습니다."

    fun checkInputPurchasingAmount(inputPurchasingAmount: String) {
        if (!hasRemainder(inputPurchasingAmount)
            or !isNumber(inputPurchasingAmount)
        ) {
            throw IllegalArgumentException(PURCHASING_AMOUNT_EXCEPTION)
        }
    }

    private fun hasRemainder(inputPurchasingAmount: String): Boolean {
        if (inputPurchasingAmount.toInt() % 1000 > 0) {
            return false
        }
        return true
    }

    private fun isNumber(inputPurchasingAmount: String): Boolean {
        if (!inputPurchasingAmount.all { it.isDigit() }) {
            return false
        }
        return true
    }
}