package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*
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
            println(lotto.returnLottoNumbers())
        lottos
    } catch (_: IllegalArgumentException) {
        -1
    }
}
fun stage3(): Any {
    println(CONSTANT.STAGE.WINNINGINPUT.message)
    val inputWinning = Console.readLine()
    val inputWinningList = inputWinning.split(",")
    return try {
        val winning = LottoGenerator().checkUserInputLotto(inputWinningList)
        println(winning.returnLottoNumbers())
        winning
    } catch (_: IllegalArgumentException) {
        -1
    }
}
fun stage4(winning : Lotto): Int {
    println(CONSTANT.STAGE.BONUSINPUT.message)
    val inputBonus = Console.readLine()
    return try {
        BonusChecker(winning,inputBonus)
        println(inputBonus)
        inputBonus.toInt()
    } catch (_: IllegalArgumentException) {
        -1
    }
}

fun main() {
    val price = stage1()
    if (price == -1) return
    val lottos = stage2(price)
    if (lottos == -1) return
    val winning = stage3()
    if (winning == -1) return
    val bonus = stage4(winning as Lotto)
    if (bonus == -1) return

}
