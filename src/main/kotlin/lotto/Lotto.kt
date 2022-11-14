package lotto

private const val LOTTO_SIZE = 6

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "[ERROR]"
        }
        require(numbers.toSet().size == LOTTO_SIZE) {
            "[ERROR]"
        }
    }

    fun getMatchingNumberCount(myLotto: List<Int>, bonusNumber: Int): LottoMatchingCount {
        val count = myLotto.map { number ->
            numbers.contains(number)
        }.count { it }

        if (count == 5 && myLotto.contains(bonusNumber)) {
            return LottoMatchingCount.FIVE_BONUS
        }

        return when (count) {
            3 -> LottoMatchingCount.THREE
            4 -> LottoMatchingCount.FOUR
            5 -> LottoMatchingCount.FIVE
            6 -> LottoMatchingCount.SIX
            else -> LottoMatchingCount.ETC
        }
    }
}