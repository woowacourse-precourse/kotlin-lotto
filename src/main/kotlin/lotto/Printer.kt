package lotto

import java.text.DecimalFormat

class Printer {
    fun printWord(word: String) = println(word)

    fun printPurchasedLotto(purchasedLotto: List<Lotto>) = purchasedLotto.forEach { eachLotto ->
        eachLotto.printLottoNumbers()
    }

    fun printResult(result: Map<LottoPrice, Int>) {
        LottoPrice.values().forEach { eachLottoStatus ->
            var eachStatusCount = 0

            result[eachLottoStatus]?.let { eachStatusCount = it }
            val msg = when (eachLottoStatus) {
                LottoPrice.NONE -> return@forEach
                LottoPrice.SECOND_PLACE -> SECOND_PLACE_MSG.format(eachLottoStatus.catchCount,
                    eachLottoStatus.price.withComma(),
                    eachStatusCount)
                else -> PLACE_MSG.format(eachLottoStatus.catchCount, eachLottoStatus.price.withComma(), eachStatusCount)
            }
            println(msg)
        }
    }

    private fun Int.withComma() = DecimalFormat("#,###").format(this)
}