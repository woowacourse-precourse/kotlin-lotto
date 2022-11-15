package lotto

class Money {
    var money: String = ""

    enum class WinMoney(private val prize: Int) {
        FifthPlace(5000),
        FourthPlace(50000),
        ThirdPlace(1500000),
        SecondPlace(30000000),
        FirstPlace(2000000000);

        fun getPrize(): Int {
            return prize
        }
    }

    fun isError(): Boolean {
        if (money == "ERROR") {
            return false
        }
        return true
    }

    fun getNumberOfPurchases(): Int {
        return money.toInt() / 1000
    }

    fun getProfitRate(winningResult: List<Int>): Double {
        val totalPrize = getTotalPrize(winningResult)
        return roundOff(calculateProfitRate(totalPrize))
    }

    private fun getTotalPrize(winningResult: List<Int>): Int {
        var totalPrize = 0
        winningResult.forEachIndexed { index, Num -> totalPrize += WinMoney.values()[index].getPrize() * Num }

        return totalPrize
    }

    private fun calculateProfitRate(totalPrize: Int): Double {
        return (totalPrize / money.toDouble() * 100)
    }


    private fun roundOff(d: Double): Double {
        return String.format("%.2f", d).toDouble()
    }
}