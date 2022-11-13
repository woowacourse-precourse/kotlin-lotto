package lotto


const val INPUT_EXCEPTION = "잘못된 입력입니다."

class Exceptions {




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