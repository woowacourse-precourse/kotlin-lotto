package lotto

enum class Winning(private val money: Int, private var number: Int) {
    THREE(5000, 0),
    FOUR(50000, 0),
    FIVE(1500000, 0),
    FIVEWITHBONUS(30000000, 0),
    SIX(2000000000, 0);

    fun addAmountAndNumberOfMatches() {
        var winningAmount = 0

        winningAmount += money
        number += 1
    }

    fun getNumberOfMatches() = number
}