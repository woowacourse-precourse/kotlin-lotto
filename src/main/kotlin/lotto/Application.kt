package lotto

private var purchaseAmount = 0

enum class ErrorType {
    AMOUNT {
        override fun print() {
            super.print()
            println("입력은 1,000의 배수여야 합니다.")
        }
    };

    open fun print() {
        print("[ERROR] ")
    }
}

fun main() {

}

fun getPurchaseAmount() {
    val inputAmount = getPurchaseAmountInput()
    checkInputAmountValid(inputAmount)

}

fun getPurchaseAmountInput(): Int {
    print("구입금액을 입력해 주세요.\n")
    return readLine()?.toInt() ?: 0
}

fun checkInputAmountValid(amount: Int) {
    if(amount == 0 || amount % 1000 != 0) {
        ErrorType.AMOUNT.print()
        throw IllegalArgumentException()
    }
}