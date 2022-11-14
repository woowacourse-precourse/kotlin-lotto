package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun sort() : List<Int> = numbers.sorted()
}

