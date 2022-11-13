package lotto

const val COST_RANGE_EXCEPTION = "구매 불가능한 금액입니다. 1000원 이상부터 구매 가능합니다."
const val COST_UNIT_EXCEPTION = "구매 불가능한 금액입니다. 1000원 단위로 구매 가능합니다."

const val INPUT_EXCEPTION = "잘못된 입력입니다."

class Exceptions {
    fun validateCost(cost: Int) {
        if (cost < 1000) {
            throw IllegalArgumentException(ERROR + COST_RANGE_EXCEPTION)
        }
        if (cost % 100 != 0) {
            throw IllegalArgumentException(ERROR + COST_UNIT_EXCEPTION)
        }
    }



    fun validateWinningNumbers(input: List<String>) {
        val numbers = listOf<Int>()
        for (x in input) {
            if (x.toIntOrNull() == null) {
                throw IllegalArgumentException(ERROR + INPUT_EXCEPTION)
            }
            numbers + x.toInt()
        }
        validateLottoNumbers(numbers)
    }

    fun validateBonusNumber(numbers: List<Int>, input: String) {
        val bonus = input.toIntOrNull()
        if (bonus == null) {
            throw IllegalArgumentException(ERROR + INPUT_EXCEPTION)
        }
        if (bonus in numbers) {
            throw IllegalArgumentException(ERROR + LOTTO_DUPLICATE_EXCEPTION)
        }
        if (bonus !in 1..45) {
            throw IllegalArgumentException(ERROR + LOTTO_RANGE_EXCEPTION)
        }
    }
}