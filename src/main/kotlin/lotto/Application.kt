package lotto

fun main() {
    val input_buy = Money().InputMoney()
    val buy = Money().InputError(input_buy)

    println()

    val buy_count = Number().BuyLottoCount(buy)
    val total_numbers=Number().PrintNumberList(buy_count)

    println()

    val lotto_numbers=WinningNumber().InputLottoNumber()
}

