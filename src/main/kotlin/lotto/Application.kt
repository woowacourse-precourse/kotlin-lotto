package lotto

fun main() {
    val input_buy = Money().InputMoney()
    val buy = Money().InputError(input_buy)

    println()

    val buy_count = Number().BuyLottoCount(buy)
    val total_numbers=Number().PrintNumberList(buy_count)

    println()

    val lotto_numbers=WinningNumber().InputLottoNumber()
    val lotto_numbers_list=WinningNumber().MakeListLottoNumber(lotto_numbers)
    println()

    val bonus = Bonus().InputBonus()
    println()

    println("당첨 통계")
    println("---")

    val winning_numbers_count= WinningCount().WinningNumbers(total_numbers,lotto_numbers_list,bonus)

    WinningCount().PrintWinningCount(winning_numbers_count)
}

