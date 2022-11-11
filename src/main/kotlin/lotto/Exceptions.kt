package lotto

const val ERROR = "[ERROR]"
const val SIZE_EXCEPTION = "로또 번호의 갯수는 6개 입니다."
const val DUPLICATE_EXCEPTION = "로또 번호는 중복이 있으면 안됩니다."
const val RANGE_EXCEPTION = "로또 번호는 1부터 45 사이의 숫자여야 합니다."

class Exceptions {
    fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ERROR + SIZE_EXCEPTION)
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(ERROR + DUPLICATE_EXCEPTION)
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(ERROR + RANGE_EXCEPTION)
        }
    }

    fun validateBonusNumber(numbers: List<Int>, bonus: Int) {
        if (bonus in numbers) {
            throw IllegalArgumentException(ERROR + DUPLICATE_EXCEPTION)
        }
        if (bonus !in 1..45) {
            throw IllegalArgumentException(ERROR + RANGE_EXCEPTION)
        }
    }
}