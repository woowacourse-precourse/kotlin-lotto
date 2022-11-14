package lotto

import java.text.DecimalFormat

enum class Result(
    private val match: Int,
    private val price: Int,
    var count: Int = 0,
    private val extra: String = ""
) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, extra = ", 보너스 볼 일치"),
    FIRST(6, 2_000_000_000);

    fun print() {
        val decimal = DecimalFormat("#,###")
        println("${match}개 일치${extra} (${decimal.format(price)}원) - ${count}개")
    }
}