package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        numbers.forEach {
            require(it in 1..45)
        }
    }

    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> {
        return numbers
    }
}
