package lotto.domain

class Judgement {

    private var rank = mutableListOf(0, 0, 0, 0, 0)

    fun getRank(winnigLotto: Lotto, bonusNumber: Int, myLottos: List<Lotto>): List<Int> {
        val correctCalculator = CorrectCalculator()
        for (lotto in myLottos) {
            val count = correctCalculator.correctLottoNumber(winnigLotto, lotto)
            val isBonusNumberCorrect = correctCalculator.correctBonusNumber(lotto, bonusNumber)
            setRank(count, isBonusNumberCorrect)
        }
        return rank
    }

    private fun setRank(count: Int, isBonusNumberCorrect: Boolean) {
        when (count) {
            3 -> rank[4] += 1
            4 -> rank[3] += 1
            5 -> {
                if (!isBonusNumberCorrect) rank[2] += 1
                if (isBonusNumberCorrect) rank[1] += 1
            }

            6 -> rank[0] += 1
        }
    }
}
