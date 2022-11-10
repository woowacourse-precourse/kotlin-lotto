package lotto.domain

class WinningNumber(val numbers: List<Int>, val bonus: Int) {
    init {
        with(LottoValidator()) {
            validateLottoNumber(numbers)
            validateBonusNumber(numbers, bonus)
        }
    }
}
