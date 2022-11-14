package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(this.duplicateChecker())
    }

    private fun duplicateChecker(): Boolean{
        return this.numbers.distinct() == this.numbers
    }
}
