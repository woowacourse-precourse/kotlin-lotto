package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == numbers.size)
    }

    fun numbers() = numbers

    // TODO: 추가 기능 구현
}
