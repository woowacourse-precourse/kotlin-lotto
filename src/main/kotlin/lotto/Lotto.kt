package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDuplicated())
    }

    private fun isDuplicated() = setOf(numbers).size != numbers.size
    fun printLotto() {
        numbers.sorted().forEachIndexed { index, i ->
            if (index == 0) print("[$i, ")
            if (index > 0 && index < numbers.size - 1) print("$i, ")
            if (index == numbers.size - 1) println("$i]")
        }
    }
}
