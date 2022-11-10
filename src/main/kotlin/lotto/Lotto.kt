package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().validateLottoNumber(numbers)
    }

    // TODO: companion object == field ??
    companion object {
        fun generate() = Lotto(
            Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
        )
    }
}
