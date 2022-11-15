package lotto

import java.text.DecimalFormat

class Printer {
    fun print(word: String) = println(word)

    fun printPurchasedLotto(purchasedLotto:List<Lotto>){
        purchasedLotto.forEach {eachLotto->
            print(eachLotto.checkLottoNumbers().toString())
        }
    }

    fun printResult(result: Map<LottoPlace, Int>) {
        LottoPlace.values().forEach { eachLottoStatus ->
            var eachStatusCount = 0

            result[eachLottoStatus]?.let { eachStatusCount = it }
            val msg = when (eachLottoStatus) {
                LottoPlace.NONE -> return@forEach
                LottoPlace.SECOND_PLACE -> SECOND_PLACE_MSG.format(eachLottoStatus.catchCount,
                    eachLottoStatus.price.withComma(),
                    eachStatusCount)
                else -> PLACE_MSG.format(eachLottoStatus.catchCount, eachLottoStatus.price.withComma(), eachStatusCount)
            }
            print(msg)
        }
    }

    private fun Int.withComma() = DecimalFormat("#,###").format(this)
}