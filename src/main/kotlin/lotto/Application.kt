package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.CONSTANT
import lotto.domain.LottoGenerator
import lotto.domain.PriceChecker
import java.lang.IllegalArgumentException

fun stage1(): Int {
    println(CONSTANT.STAGE.PRICEINPUT.message)
    return try {
        val lottoPrice = Console.readLine()
        PriceChecker(lottoPrice)
        lottoPrice.toInt()
    }catch (e: IllegalArgumentException){
        -1
    }
}
fun stage2(price:Int): Any {
    val lottoCnt = LottoGenerator().getLottoCountValue(price)
    println(lottoCnt.toString()+CONSTANT.STAGE.LOTTOCOUNTOUPUT.message)
    return try {
        val lottos = LottoGenerator().createLottoNumber(lottoCnt)
        for(lotto in lottos)
            println(lotto.printLotto())
        return lottos
    } catch (_: IllegalArgumentException) {
        -1
    }
}
fun main() {
    val price = stage1()
    if (price == -1) return
    val lottos = stage2(price)
    if (lottos==-1) return


}
