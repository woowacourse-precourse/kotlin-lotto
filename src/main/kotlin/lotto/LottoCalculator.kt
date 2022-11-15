package lotto

class LottoCalculator {
    companion object {
        fun calculateLottoCount(price: Int): Int {
            return price/1000
        }

        fun calculateRate(price: Int, winningResult: Map<WinningType, Int>): Double {
            var total = 0
            for(i in winningResult.keys) {
                total += (winningResult[i]!! * i.reward)
            }
            return 100 * total.toDouble()/price.toDouble()
        }
    }
}