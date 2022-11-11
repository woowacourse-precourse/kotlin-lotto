package lotto

const val ERROR = "[ERROR]"
const val COST_RANGE_EXCEPTION = "구매 불가능한 금액입니다. 1000원 이상부터 구매 가능합니다."
const val COST_UNIT_EXCEPTION = "구매 불가능한 금액입니다. 1000원 단위로 구매 가능합니다."
const val LOTTO_SIZE_EXCEPTION = "로또 번호의 갯수는 6개 입니다."
const val LOTTO_DUPLICATE_EXCEPTION = "로또 번호는 중복이 있으면 안됩니다."
const val LOTTO_RANGE_EXCEPTION = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val BONUS_SIZE_EXCEPTION = "보너스 번호의 갯수는 1개입니다."

class Exceptions {
    fun validateCost(cost: Int) {
        if (cost < 1000) {
            throw IllegalArgumentException(ERROR + COST_RANGE_EXCEPTION)
        }
        if (cost % 100 != 0) {
            throw IllegalArgumentException(ERROR + COST_UNIT_EXCEPTION)
        }
    }

    fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ERROR + LOTTO_SIZE_EXCEPTION)
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(ERROR + LOTTO_DUPLICATE_EXCEPTION)
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(ERROR + LOTTO_RANGE_EXCEPTION)
        }
    }

    fun validateBonusNumber(numbers: List<Int>, input: String) {
        val bonus = input.toInt()
        if (bonus in numbers) {
            throw IllegalArgumentException(ERROR + LOTTO_DUPLICATE_EXCEPTION)
        }
        if (bonus !in 1..45) {
            throw IllegalArgumentException(ERROR + LOTTO_RANGE_EXCEPTION)
        }
    }
}