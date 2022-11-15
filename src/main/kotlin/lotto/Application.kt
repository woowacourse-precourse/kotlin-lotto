package lotto

fun main() {
    val baseData = BaseData()
    baseData.baseData()
    val lotto = Lotto(baseData.LottoNum)
    val winLotto = lotto.checkAllWinLotto(baseData.purchasedLotto,baseData.bonusNum)
    lotto.printResult(winLotto,baseData.inputMoney)
}











