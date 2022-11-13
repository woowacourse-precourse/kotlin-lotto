package lotto.domain

class Lotto(numbers: List<Int>) {
    init {
        validateLottoSize(numbers)
        validateLottoDuplicate(numbers)
        validateLottoRange(numbers)
    }

    private fun validateLottoSize (numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(LOTTO_SIZE_EXCEPTION)
        }
    }

    private fun validateLottoDuplicate (numbers: List<Int>) {
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(LOTTO_DUPLICATE_EXCEPTION)
        }
    }

    private fun validateLottoRange (numbers: List<Int>) {
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(LOTTO_RANGE_EXCEPTION)
        }
    }

    companion object {
        const val LOTTO_SIZE_EXCEPTION = "[ERROR] 로또 번호의 갯수는 6개 입니다."
        const val LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 로또 번호는 중복이 있으면 안됩니다."
        const val LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
