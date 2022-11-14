package lotto

import lotto.domain.Result
import lotto.domain.GenerateLotto
import lotto.domain.GetPrice
import lotto.ui.Input
import lotto.ui.Output


fun main() {
    val price = getMoney()

    val lottoLog = purchaseLotto(price)

    val lottoNumber = getLottoNumber()

    val bonusNumber = getBonusNumber(lottoNumber)

    val result = getResult(lottoLog, lottoNumber, bonusNumber)


}

fun getMoney(): Int {
    val strPrice = Input.getPrice()
    return GetPrice.getNum(strPrice)
}

fun purchaseLotto(price: Int): ArrayList<Lotto> {
    val lottoLog = ArrayList<Lotto>()
    val nLotto = GetPrice.count(price)

    Output.printCount(nLotto)

    for (i in 0 until nLotto) {
        val lotto = GenerateLotto.generate()
        Output.printLotto(lotto)
        lottoLog.add(lotto)
    }

    return lottoLog
}

fun getLottoNumber(): Lotto {
    val lottoString = Input.getLottoNumbers()

    return GenerateLotto.stringToList(lottoString)
}

fun getBonusNumber(lotto: Lotto): Int {
    val bonusString = Input.getBonusNumber()

    return GenerateLotto.bonusNumber(bonusString, lotto)
}

fun getResult(lottoLog: ArrayList<Lotto>, lottoNumber: Lotto, bonusNumber: Int): List<Int> {
    val result = Result.compare(lottoLog, lottoNumber, bonusNumber)

    Output.printResult(result)

    return result
}
