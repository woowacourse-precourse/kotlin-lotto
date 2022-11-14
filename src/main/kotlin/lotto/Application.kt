package lotto

import lotto.domain.Rank
import lotto.domain.Revenue
import lotto.util.ExceptionChecker
import lotto.util.LottoGenerator
import lotto.domain.WinLotto
import lotto.view.LottoView
import kotlin.properties.Delegates

val lottoIO = LottoView()
val exceptionChecker = ExceptionChecker()
val generator = LottoGenerator()
val win = WinLotto()
val revenue = Revenue()

var price by Delegates.notNull<Long>()

fun main() {
    setLotto()
}

fun setLotto(){
    price = lottoIO.getPrice()
    exceptionChecker.priceExceptionCheck(price)
    val n = price / 1000

    val lottos = ArrayList<List<Int>>()
    for(i in 0 until n){
        lottos.add(generator.generate())
    }

    lottoIO.printLotto(lottos)

    computeLotto(lottos)
}

fun  computeLotto(lottos: ArrayList<List<Int>>){
    val winnigNum = lottoIO.getWinningNumber()
    exceptionChecker.validLottoNumExceptionCheck(winnigNum)
    val bonusNum = lottoIO.getBonusNumber()
    exceptionChecker.validBonusNumExceptionCheck(winnigNum, bonusNum)
    val rankResult = win.getRankResult(lottos, winnigNum, bonusNum)

    printResultLotto(rankResult)
}

fun printResultLotto(rankResult: MutableMap<Rank, Int>){
    lottoIO.printRankResult( rankResult)
    lottoIO.printRevenue(revenue.getRevenue(rankResult,price))
}
