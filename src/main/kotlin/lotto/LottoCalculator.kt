package lotto

const val LOTTO_SIZE = 6

class LottoCalculator(
    private val consumerLottos: List<List<Int>>,
    private val winningLotto: Lotto,
    private val bonusNumber: Int
) {
    fun calculateLotto(): List<Int> {
        val winnings = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (consumerLotto in consumerLottos) {
            val correctCount = compareNumbers(consumerLotto)
        }
        return winnings
    }

    private fun compareNumbers(consumerLotto: List<Int>): Int {
        var count = 0
        for (i in 0 until LOTTO_SIZE) {
            if (winningLotto.contains(consumerLotto[i])) {
                count++
            }
        }
        return count
    }
}