package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getSortLotto() : List<Int>{
        return numbers.sorted()
    }
}
