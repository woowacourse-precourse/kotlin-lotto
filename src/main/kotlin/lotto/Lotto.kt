package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDuplicated())
    }

    private fun isDuplicated() = setOf(numbers).size != numbers.size
}
