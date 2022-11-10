package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    val winNumber = numbers
    // TODO: 추가 기능 구현
}
