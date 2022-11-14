package lotto

import lotto.view.Message


class EarningsRate(private val finalMoney: Int, private val inputPrice: Int) {
    fun result() {
        Message.showRate(calculateRate())
    }

    private fun calculateRate(): Double {
        return ((finalMoney.toDouble() / inputPrice.toDouble()) * 100.00)
    }
}
