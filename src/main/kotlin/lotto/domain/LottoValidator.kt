package lotto.domain

import lotto.LOTTO_LENGTH
import lotto.LOTTO_MAX_NUM
import lotto.LOTTO_MIN_NUM
import lotto.util.requireWithPrefix

class LottoValidator {
    fun validateLottoNumber(numbers: List<Int>) {
        requireWithPrefix(
            numbers.size == LOTTO_LENGTH,
            ERROR_LOTTO_LENGTH
        )
        requireWithPrefix(
            numbers.all { it in LOTTO_MIN_NUM..LOTTO_MAX_NUM },
            ERROR_LOTTO_NUM_RANGE
        )
        requireWithPrefix(
            numbers == numbers.distinct(),
            ERROR_LOTTO_NUM_DUPLICATED
        )
    }

    fun validateBonusNumber(numbers: List<Int>, bonus: Int) {
        requireWithPrefix(
            bonus in LOTTO_MIN_NUM..LOTTO_MAX_NUM,
            ERROR_BONUS_NUM_RANGE
        )
        requireWithPrefix(
            bonus !in numbers,
            ERROR_BONUS_NUM_DUPLICATED
        )
    }

    companion object {
        private const val ERROR_LOTTO_LENGTH = "로또 번호는 ${LOTTO_LENGTH}개의 숫자여야 합니다."
        private const val ERROR_LOTTO_NUM_RANGE = "로또 번호는 ${LOTTO_MIN_NUM}부터 $LOTTO_MAX_NUM 사이의 숫자여야 합니다."
        private const val ERROR_LOTTO_NUM_DUPLICATED = "로또 번호에는 중복되는 숫자가 없어야 합니다."
        private const val ERROR_BONUS_NUM_RANGE = "보너스 번호는 ${LOTTO_MIN_NUM}부터 $LOTTO_MAX_NUM 사이의 숫자여야 합니다."
        private const val ERROR_BONUS_NUM_DUPLICATED = "보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다."
    }
}
