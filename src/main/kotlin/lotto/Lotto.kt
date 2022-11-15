package lotto

import _enum.LottoEnum

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private var totalPrice = 0L
    private val lottoMap = mapOf(
        3 to LottoEnum.THREE_CORRECT,
        4 to LottoEnum.FOUR_CORRECT,
        5 to LottoEnum.FIVE_CORRECT,
        6 to LottoEnum.SIX_CORRECT,
        15 to LottoEnum.FIVE_CORRECT_BONUS
    )

    fun compareLotto(correct: List<Int>, bonus: Int) {
        var count = numbers.intersect(correct.toSet()).size
        if (count == 5 && bonus in numbers) count += 10
        if (count !in lottoMap.keys) return
        lottoMap[count]!!.count += 1
        totalPrice += lottoMap[count]!!.price
    }
    fun getTotalPrice(): Long {
        return totalPrice
    }
}
