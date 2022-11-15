package lotto


class LottoCalculator(
    private val consumerLottos: List<List<Int>>,
    private val winningLotto: Lotto,
    private val bonusNumber: Int
) {

    init {
        require(!checkLottoContainBonusNumber()) { println(ERROR_BONUS_CONTAIN_LOTTO) }
    }

    fun checkLottoContainBonusNumber(): Boolean {
        return winningLotto.contains(bonusNumber)
    }

    fun calculateLotto(): List<Int> {
        val winnings = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (consumerLotto in consumerLottos) {
            val correctCount = compareNumbers(consumerLotto)
            if (correctCount == SECOND_PLACE_COUNT && consumerLotto.contains(bonusNumber)) {
                winnings[SECOND_PLACE_INDEX]++
            } else if (correctCount == FIRST_PLACE_COUNT) {
                winnings[FIRST_PLACE_INDEX]++
            } else if (correctCount >= WINNINGS_COUNT_MIN) {
                winnings[7 - correctCount]++
            }
        }
        return winnings
    }

    private fun compareNumbers(consumerLotto: List<Int>): Int {
        var count = 0
        for (index in 0 until LOTTO_SIZE) {
            if (winningLotto.contains(consumerLotto[index])) {
                count++
            }
        }
        return count
    }
}