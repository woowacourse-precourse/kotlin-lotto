package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현

    override fun toString(): String {
        return numbers.toString()
    }
}
