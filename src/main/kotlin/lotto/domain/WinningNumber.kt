package lotto.domain

import lotto.util.requireWithPrefix

data class WinningNumber(val winLotto: Lotto, val bonus: Int) {
    init {
        requireWithPrefix(bonus in Lotto.MIN_NUM..Lotto.MAX_NUM, ERROR_BONUS_NUM_RANGE)
        requireWithPrefix(bonus !in winLotto, ERROR_BONUS_NUM_DUPLICATED)
    }

    companion object {
        private const val ERROR_BONUS_NUM_RANGE =
            "보너스 번호는 ${Lotto.MIN_NUM}부터 ${Lotto.MAX_NUM} 사이의 숫자여야 합니다."
        private const val ERROR_BONUS_NUM_DUPLICATED =
            "보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다."
    }
}
