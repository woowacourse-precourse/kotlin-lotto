package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.requireWithPrefix

class Lotto(private val numbers: List<Int>) {
    init {
        requireWithPrefix(numbers.size == LOTTO_LENGTH, "로또 번호는 ${LOTTO_LENGTH}개의 숫자여야 합니다.")
    }

    companion object {
        fun generate() = Lotto(
            Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
        )
    }
}
