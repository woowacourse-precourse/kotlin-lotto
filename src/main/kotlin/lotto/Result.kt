package lotto

import java.text.DecimalFormat

enum class Result(
    private val matchCount: Int,
    private val price: Int,
    private var winCount: Int = 0,
    private val extraString: String = ""
) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, extraString = ", 보너스 볼 일치"),
    FIRST(6, 2_000_000_000);

    fun print() {
        val decimal = DecimalFormat("#,###")
        println("${matchCount}개 일치${extraString} (${decimal.format(price)}원) - ${winCount}개")
    }

    fun getEarningRate() = this.price * this.winCount

    fun addWinCount() {
        this.winCount++
    }
}
