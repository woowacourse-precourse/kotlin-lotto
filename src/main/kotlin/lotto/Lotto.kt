package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
    private var totalPrice = 0
    fun compareLotto(correct: List<Int>, bonus: Int) {
        var count = numbers.intersect(correct.toSet()).size
        if (count == 5 && bonus in numbers) count += 10
        val lottoMap = mapOf(
            3 to LottoEnum.THREE_CORRECT,
            4 to LottoEnum.FOUR_CORRECT,
            5 to LottoEnum.FIVE_CORRECT,
            6 to LottoEnum.SIX_CORRECT,
            15 to LottoEnum.FIVE_CORRECT_BONUS
        )
        if (count !in lottoMap.keys) return
        lottoMap[count]!!.count += 1
        totalPrice += lottoMap[count]!!.price
    }
    fun getTotalPrice(): Int {
        return totalPrice
    }
}
