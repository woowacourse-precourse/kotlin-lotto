package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().size)
    }

    fun getNumbers(): List<Int> = numbers

    fun getNumbersSize(): Int = numbers.size
    // TODO: 추가 기능 구현
}
