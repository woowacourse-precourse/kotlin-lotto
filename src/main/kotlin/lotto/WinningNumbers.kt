package lotto

import lotto.util.requireWithPrefix

class WinningNumbers(val numbers: List<Int>, val bonus: Int) {

    init {
        with(Validator()) {
            validateLottoNumber(numbers)
            validateBonusNumber(numbers, bonus)
        }
    }
}