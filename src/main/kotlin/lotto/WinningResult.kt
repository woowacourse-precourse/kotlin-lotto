package lotto

class WinningResult {

    fun matchLotto(answer: Lotto, user: Lotto, bonus: Int): LottoGrade {

        val count = user.countCompareLotto(answer)
        val bonusResult = user.matchBonus(bonus)

        when(count) {
            3 -> return LottoGrade.FIFTH
            4 -> return LottoGrade.FOURTH
            5 -> {
                if(bonusResult) return LottoGrade.SECOND
                return LottoGrade.THIRD
            }
            6 -> return LottoGrade.FIRST
            else -> return LottoGrade.NOTHING
        }
    }
}