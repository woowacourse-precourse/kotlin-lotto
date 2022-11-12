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
        }
    }
}