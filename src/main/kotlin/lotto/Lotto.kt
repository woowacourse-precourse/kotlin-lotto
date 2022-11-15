package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNumbers():List<Int>{
        return this.numbers
    }

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }

}


