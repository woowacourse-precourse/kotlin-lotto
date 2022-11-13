package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoBundle(): MutableList<List<Int>> {
        val lottoBundle = mutableListOf<List<Int>>()
        lottoBundle.add(numbers)

        return lottoBundle
    }
}
