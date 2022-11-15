package lotto.data

import lotto.error.ErrorMessages

private typealias WinningLottoError = ErrorMessages.WinningLottoEnum

class WinningLotto constructor(lotto: Lotto, bonus: Int) {

    private val lotto: Lotto
    private val bonus: Int

    init {
        require(bonus in Lotto.Range) { WinningLottoError.OutOfRangeNumbers }
        require(!lotto.contains(bonus)) { WinningLottoError.NotDuplicated }

        this.lotto = lotto
        this.bonus = bonus
    }

    fun matches(lotto: Lotto): Pair<Int, Boolean> {
        val hitCount = lotto.matches(this.lotto)
        val isBonusHit = lotto.contains(this.bonus)
        return hitCount to (hitCount == 5 && isBonusHit)
    }

    override fun toString(): String {
        return "$lotto [$bonus]"
    }
}
