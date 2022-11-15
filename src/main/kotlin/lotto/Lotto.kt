package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    private fun winningsCount(lotto: List<Int>): Int = numbers.filter { it ->
        lotto.contains(it)
    }.size

    fun lottoCalculate(lottos: List<List<Int>>, bonus: Int): List<Int> {
        val lottoResult = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
        lottos.forEach { it ->
            val count = winningsCount(it)
            if (it.contains(bonus) || count == 6) {
                lottoResult[count + 1]++
                return@forEach
            }
            lottoResult[count]++
        }
        return lottoResult.takeLast(5)
    }

}
