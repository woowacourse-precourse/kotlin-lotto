package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printLotto() {
        numbers.sorted()
        println(numbers)
    }


}
