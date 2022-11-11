package lotto

const val ERROR = "[ERROR]"
const val SIZE_ERROR_EXCEPTION = "로또 번호의 갯수는 6개 입니다."
const val DUPLICATE_ERROR_EXCEPTION = "로또 번호는 중복이 있으면 안됩니다."
const val RANGE_ERROR_EXCEPTION = "로또 번호는 1부터 45 사이의 숫자여야 합니다."

class Exceptions {
    fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ERROR + SIZE_ERROR_EXCEPTION)
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(ERROR + DUPLICATE_ERROR_EXCEPTION)
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(ERROR + RANGE_ERROR_EXCEPTION)
        }
    }

}