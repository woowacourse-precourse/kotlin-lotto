package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().validateLottoNumber(numbers)
    }

    private fun getOverlapNumber(numbers: List<Int>) =
        this.numbers.count { it in numbers }


    // TODO: companion object == field ??
    companion object {
        fun generate() = Lotto(
            Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
        )
    }
}
