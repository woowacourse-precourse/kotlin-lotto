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

    price = try {
        lottoIO.getPrice()
    }catch (e: IllegalArgumentException){
        return
    }

    val n = price / 1000

    val lottos = ArrayList<List<Int>>()
    for(i in 0 until n){
        lottos.add(generator.generate())
    }

    lottoIO.printLotto(lottos)

    computeLotto(lottos)
}

fun  computeLotto(lottos: ArrayList<List<Int>>){
    val winningNum = try {
        lottoIO.getWinningNumber()
    }catch (e: IllegalArgumentException){
        return
    }
    val bonusNum = try {
        lottoIO.getBonusNumber(winningNum)
    }catch (e: IllegalArgumentException){
        return
    }
    exceptionChecker.validBonusNumExceptionCheck(winningNum, bonusNum)
    val rankResult = win.getRankResult(lottos, winningNum, bonusNum)

    printResultLotto(rankResult)
}

fun printResultLotto(rankResult: MutableMap<Rank, Int>){
    lottoIO.printRankResult( rankResult)
    lottoIO.printRevenue(revenue.getRevenue(rankResult,price))
}
