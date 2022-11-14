package lotto

class EarningsRate(private val finalMoney: Int, private val inputPrice: Int) {
    fun result() {
        showRateMessage(calculateRate())
    }

    private fun showRateMessage(rate: Double) {
        println("총 수익률은 $rate%입니다.")
    }

    private fun calculateRate(): Double {
        return ((finalMoney.toDouble() / inputPrice.toDouble()) * 100.00)
    }
}
