package lotto

class Lotto(private val numbers: List<Int>) {

    private var winningNumber = listOf<Int>()

    init {
        require(numbers.size == 6) { Error.SIX_NUMBER.string }
        require(numbers.toSet().size == 6) { Error.OVERLAP.string }
        require((0..45).contains<Any>(numbers)) { Error.RANGE.string }
        winningNumber = numbers
    }

    fun changeToElement(): List<Int> {
        return winningNumber.toList()
    }
}
