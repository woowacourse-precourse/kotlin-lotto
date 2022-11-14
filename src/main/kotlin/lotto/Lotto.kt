package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {throw IllegalArgumentException(ERROR_LENGTH)}
        require(numbers.toSet().size == 6) {throw IllegalArgumentException(ERROR_DISTINCT_NUMBERS)}
    }

    // TODO: 추가 기능 구현
    fun getLottoNumbers() = numbers.sorted()

    companion object {
        const val ERROR_LENGTH = "[ERROR] 로또 번호는 6개가 입력되어야 합니다."
        const val ERROR_DISTINCT_NUMBERS = "[ERROR] 중복된 숫자가 입력되었습니다."
    }
}
