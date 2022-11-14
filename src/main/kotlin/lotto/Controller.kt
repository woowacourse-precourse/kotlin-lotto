package lotto

class Controller() {

    // 구매 로또 금액 받기
    fun getLottoPrice(inputPrice: Int): Int {
        val numberOfLotto = LottoGame().calculateNumberOfLotto(inputPrice)
        view.View().tellNumOfLotto(numberOfLotto)
        return numberOfLotto
    }
    // 정답 로또 번호 받기
    fun answerLottoNum(): MutableList<Int> {
        view.View().answerNumbersMessage()
        val answerNumbers = LottoGame().inputAnswerNumbers()
        Lotto(answerNumbers).checkinputAnswer()
        return answerNumbers
    }

    fun bonusLottoNum(): String {
        view.View().bonusNumberMessage()
        val inputBonusPrice = LottoGame().inputNum().toString()
        LottoGame().checkinputBonus(inputBonusPrice)
        return inputBonusPrice
    }

    fun winLotto(
        doubleLottos: MutableList<List<Int>>,
        answerNumbers: MutableList<Int>,
        bonusNumber: String,
        inputPrice: Int
    ) {
        val winList = LottoGame().computeRank(doubleLottos, answerNumbers, bonusNumber.toInt())
        view.View().printStatsRank(winList)
        val revenuePercent = LottoGame().statsRevenue(inputPrice, winList)
        view.View().printStatsRevenue(revenuePercent)
    }

}

