package lotto.domain

import lotto.ui.GuideLotto

class Seller(private val payment: Int) {

    private fun countLottoQuantity(): Int {
        val lottoQuantity = payment / 1000
        GuideLotto().printLottoCount(lottoQuantity)
        return payment / 1000
    }

    fun setLotto(): MutableList<List<Int>> {
        return LottoMachine(countLottoQuantity()).getLottoBundle()
    }
}