package lotto

class Profit(private val prizeCount: Map<Int, Int>, private val money: Int) {
    fun calculateRate(): String {
        val totalAmount = prizeCount.entries
            .sumOf { (lottoPrize, count) ->
                lottoPrize * count
            }.toFloat()
        return "%.1f".format(totalAmount / money * HUNDRED_NUMBER)
    }

    companion object {
        private const val HUNDRED_NUMBER = 100
    }
}