package lotto

import lotto.util.requireWithPrefix

class WinningNumbers(numbers: List<Int>, val bonus: Int) {
    val numbers: Lotto = Lotto(numbers)

    init {
        requireWithPrefix(
            bonus in LOTTO_MIN_NUM..LOTTO_MAX_NUM,
            "보너스 번호는 ${LOTTO_MIN_NUM}부터 ${LOTTO_MAX_NUM} 사이의 숫자여야 합니다."
        )
    }
}