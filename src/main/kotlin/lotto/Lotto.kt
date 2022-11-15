package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){ Error.SixNumber.message }
        require(numbers.toSet().size == 6){ Error.DuplicateNumber.message }
        numbers.forEach { number ->
            if(number < 1 || number > 45) throw IllegalArgumentException(Error.OutOfRange.message)
        }
    }

    // TODO: 추가 기능 구현
    fun getLottoNumber(): List<Int> {
        return numbers
    }
}
