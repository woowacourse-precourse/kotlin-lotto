package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val price = Price.getPurchasePrice()
    val lottoNumbers = publishLottoNumbers(price)
    val winningBonusNumbers = Winning.getWinningBonusNumbers()
}
fun getLottoCount(price: Int) = price / 1000

fun printLottoPurchaseCountMessage(price: Int) = println("${getLottoCount(price)}개를 구매했습니다.")

fun generateLottoNumber(): List<Int> = Randoms.pickUniqueNumbersInRange(1,45,6)

fun generateLottoNumbers(price: Int): ArrayList<Lotto> {
    val lottoNumbers = arrayListOf<Lotto>()
    val size = getLottoCount(price)

    for (i in 0 until size) {
        val lottoNumber = Lotto(generateLottoNumber())
        lottoNumbers.add(lottoNumber)
    }

    return lottoNumbers
}

fun printNumbersByAscending(numbers: ArrayList<Lotto>) {
    for (i in numbers.indices) numbers[i].printNumbersByAscending()
}

fun publishLottoNumbers(price: Int): ArrayList<Lotto> {
    val lottoNumbers = generateLottoNumbers(price)

    printLottoPurchaseCountMessage(price)
    printNumbersByAscending(lottoNumbers)

    return lottoNumbers
}