package lotto.data

import lotto.error.ErrorMessages

private typealias WinningLottoError = ErrorMessages.WinningLottoEnum

class WinningLotto(numbers: List<Int>, bonusNumber: Int) {

    private val lotto: Lotto
    private val bonus: Int

    init {
        require(bonusNumber in Lotto.Range) { WinningLottoError.OutOfRangeNumbers }
        require(!numbers.contains(bonusNumber)) { WinningLottoError.NotDuplicated }

        lotto = Lotto(numbers)
        bonus = bonusNumber
    }

    fun matches(lotto: Lotto): Pair<Int, Boolean> {
        return lotto.matches(this.lotto) to lotto.contains(bonus)
    }

    override fun toString(): String {
        return "$lotto [$bonus]"
    }
}
