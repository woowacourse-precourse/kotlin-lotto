package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDuplicate())
    }

    private fun isDuplicate() = numbers.distinct().size != numbers.size

    fun getLottoNumbers(): List<Int> = numbers
}