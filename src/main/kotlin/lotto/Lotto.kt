package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.requireWithPrefix

class Lotto(private val numbers: List<Int>) {
    init {
        requireWithPrefix(
            numbers.size == LOTTO_LENGTH,
            "로또 번호는 ${LOTTO_LENGTH}개의 숫자여야 합니다."
        )
        requireWithPrefix(
            numbers.all { it in LOTTO_MIN_NUM..LOTTO_MAX_NUM },
            "로또 번호는 ${LOTTO_MIN_NUM}부터 ${LOTTO_MAX_NUM} 사이의 숫자여야 합니다."
        )
        requireWithPrefix(
            numbers == numbers.distinct(),
            "로또 번호에는 중복되는 숫자가 없어야 합니다."
        )
    }

    companion object {
        fun generate() = Lotto(
            Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
        )
    }
}
