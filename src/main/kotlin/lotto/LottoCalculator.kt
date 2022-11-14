package lotto

class LottoCalculator {
    companion object {
        fun calculateLottoCount(price: Int): Int {
            return price/1000
        }

        fun calculateYield(price: Int, winningResult: Map<WinningType, Int>): Double {
            var total = 0
            for(i in winningResult.keys) {
                total += (winningResult[i]!! * i.reward)
            }
            return total.toDouble()/price * 100
        }
    }
}