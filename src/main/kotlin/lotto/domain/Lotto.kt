package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun numbers() = numbers

    // TODO: 추가 기능 구현
}
