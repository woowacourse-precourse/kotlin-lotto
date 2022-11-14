package lotto

import java.text.DecimalFormat

enum class LottoResult(val price: Int, private val doc: String) {
    First(2000000000, "6개 일치"),
    Second(30000000,"5개 일치, 보너스 볼 일치"),
    Third(1500000, "5개 일치"),
    Fourth(50000, "4개 일치"),
    Fifth(5000, "3개 일치"),
    None(0, "미당첨");

    val description get() = "$doc (${priceString()}원)"
    private fun priceString(): String = DecimalFormat("#,###").format(price)
}