package lotto

class ProfitPrinter {
    fun printProfit(rateOfProfit: Double) {
        val rate = String.format("%.1f", rateOfProfit)
        println("총 수익률은 ${rate}%입니다.")
    }
}