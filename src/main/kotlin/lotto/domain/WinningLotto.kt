package lotto.domain

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Int) {

    init {
        isValidBonusNumber()
    }

    fun matching(lotto: List<Int>): Ranking {
        var count = 0
        var hasLottoBonusNumber = false
        for (i in lotto) {
            if (winningLotto.getLottoNumberList().contains(i)) {
                count += 1
            }
            if (i == bonusNumber) {
                hasLottoBonusNumber = true
            }
        }
        return Ranking.getMatchingResult(count, hasLottoBonusNumber)
    }

    private fun isValidBonusNumber() {
        val lottoNumList = winningLotto.getLottoNumberList()
        if (lottoNumList.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR]: 당첨 번호와 보너스 번호는 중복될 수 없다.")
        }
    }
}