package lotto

class Calculator {
    var lottoResults = mutableListOf<LottoResultState>()

    fun getLottoCount(amount: Int) = amount / ONE_THOUSAND

    fun getLottoResult(boughtLotteries: List<List<Int>>, winLottery: List<Int>, bonus: Int) {
        var correctCount: Int
        var isMatchedBonus: Boolean
        boughtLotteries.forEach {
            val set = it.toMutableSet()
            set.addAll(winLottery)
            correctCount = 12 - set.count()
            set.add(bonus)
            isMatchedBonus = (correctCount == 12 - set.count())
            saveRankToList(correctCount, isMatchedBonus)
        }
    }

    fun getYield(amount: Int): String {
        var winAmount = 0
        lottoResults.forEach {
            winAmount += when (it) {
                LottoResultState.FIRST -> 2000000000
                LottoResultState.SECOND -> 30000000
                LottoResultState.THIRD -> 1500000
                LottoResultState.FOURTH -> 50000
                LottoResultState.FIFTH -> 5000
                else -> 0
            }
        }
        return String.format("%.1f", (winAmount * 100.0) / amount)
    }

    private fun saveRankToList(correctCount: Int, isMatchedBonus: Boolean) {
        when {
            correctCount == 6 -> lottoResults.add(LottoResultState.FIRST)
            correctCount == 5 && isMatchedBonus -> lottoResults.add(LottoResultState.SECOND)
            correctCount == 5 -> lottoResults.add(LottoResultState.THIRD)
            correctCount == 4 -> lottoResults.add(LottoResultState.FOURTH)
            correctCount == 3 -> lottoResults.add(LottoResultState.FIFTH)
            else -> lottoResults.add(LottoResultState.NONE)
        }
    }
}