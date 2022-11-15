package lotto

fun main() {
    val input_buy = Money().InputMoney()
    val buy = Money().InputError(input_buy)

    println()

    val buy_count = Number().BuyLottoCount(buy)
}

