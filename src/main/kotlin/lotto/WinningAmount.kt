package lotto

enum class WinningAmount(private val winningAmount: Int, var number: Int) {
    FIRST(2_000_000_000, 0),
    SECOND(30_000_000, 0),
    THIRD(1_500_000, 0),
    FOURTH(50_000, 0),
    FIFTH(5_000, 0);

    fun firstIncome(): Int {
        return FIRST.winningAmount * FIRST.number
    }

    fun secondIncome(): Int {
        return SECOND.winningAmount * SECOND.number
    }

    fun thirdIncome(): Int {
        return THIRD.winningAmount * THIRD.number
    }

    fun fourthIncome(): Int {
        return FOURTH.winningAmount * FOURTH.number
    }

    fun fifthIncome(): Int {
        return FIFTH.winningAmount * FIFTH.number
    }
}