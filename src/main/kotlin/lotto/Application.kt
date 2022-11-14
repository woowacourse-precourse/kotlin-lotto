package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import camp.nextstep.edu.missionutils.Console
import lotto.domain.PriceChecker
import java.lang.IllegalArgumentException
fun priceChecker(): Int {
    return try {
        val lottoPrice = Console.readLine()
        PriceChecker(lottoPrice)
        lottoPrice.toInt()
    }catch (e: IllegalArgumentException){
        -1
    }
}
fun main() {
    val price = priceChecker()
    if (price == -1) return

}
