package util


fun printErrorMessage(errorType: ErrorType) {
    println("[ERROR] ${errorType.parseErrorType()}")
}

fun printLottoGradeCountToMessage(
    grade: Int,
    count: Int,
) {
    println(
        when (grade) {
            5 -> "3개 일치 (5,000원) - ${count}개"
            4 -> "4개 일치 (50,000원) - ${count}개"
            3 -> "5개 일치 (1,500,000원) - ${count}개"
            2 -> "5개 일치, 보너스 볼 일치 (30,000,000원) - ${count}개"
            1 -> "6개 일치 (2,000,000,000원) - ${count}개"
            else -> ""
        }
    )
}

fun printLottoEarningsRate(lottoPrizeSum: Long, paidMoney: Int) {
    val ratio = lottoPrizeSum / paidMoney.toDouble()
    println("총 수익률은 ${String.format("%.1f", (ratio * 100))}%입니다.")
}