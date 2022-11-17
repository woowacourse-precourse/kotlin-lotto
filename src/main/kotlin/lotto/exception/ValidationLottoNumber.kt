package lotto.exception

const val DUPLICATE_LOTTO_NUMBER = "로또 번호가 중복되어선 안됩니다."
const val THE_NUMBER_OF_LOTTO_NUMBERS = 6

fun validateLottoNumbers(numbers: List<Int>): Boolean {
    if (numbers.distinct().size != THE_NUMBER_OF_LOTTO_NUMBERS) {
        throw IllegalArgumentException(ERROR + DUPLICATE_LOTTO_NUMBER)
    }
    for (number in numbers){
        if (number !in LOTTO_START_NUMBER..LOTTO_END_NUMBER){
            throw IllegalArgumentException(ERROR + NOT_LOTTO_NUMBER_RANGE)
        }
    }
    return true
}