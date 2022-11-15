package lotto

private var purchaseAmount = 0

fun main() {

}

fun getPurchaseAmount() {
    val inputAmount = getPurchaseAmountInput()
}

fun getPurchaseAmountInput(): Int {
    print("구입금액을 입력해 주세요.\n")
    return readLine()?.toInt() ?: 0
}