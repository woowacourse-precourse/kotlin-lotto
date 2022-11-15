package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.Math.round
import java.text.DecimalFormat

fun main() {
    val baseData = BaseData()
    val lotto = Lotto(baseData.LottoNum)
    val winLotto = lotto.checkAllWinLotto(baseData.purchasedLotto,baseData.bonusNum)
    lotto.printResult(winLotto,baseData.inputMoney)
}











