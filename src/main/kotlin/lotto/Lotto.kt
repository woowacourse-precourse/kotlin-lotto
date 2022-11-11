package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!isDoubleCheck())
    }
    private fun isDoubleCheck() = numbers.toSet().size != numbers.size


    // TODO: 추가 기능 구현
}
