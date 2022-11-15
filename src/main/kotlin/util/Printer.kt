package util

class Printer {
    fun printPurchaseMessage() = println("구입금액을 입력해 주세요.")

    fun printCountLotto(count: Int) = println("${count}개를 구매했습니다.")

    fun printInputLottoMessage() = println("당첨 번호를 입력해 주세요.")

    fun printInputBonusMessage() = println("보너스 번호를 입력해 주세요.")

    fun printLottoResultMessage() = println("당첨 통계")

    fun printReturnRate(rate: Float) = println("총 수익률은" + "%.2f".format(rate) + "입니다.")

    fun printLottoResultTable(winnings: List<Int>) {
        val winningsTable = listOf(FIVTH, FOURTH, THIRD, SECOND, FIRST)
        winnings.forEachIndexed { idx, it ->
            println("${winningsTable[idx]}$it")
        }
    }

    companion object {
        const val FIVTH = "3개 일치 (5,000원) - "
        const val FOURTH = "4개 일치 (50,000원) - "
        const val THIRD = "5개 일치 (1,500,000원) - "
        const val SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val FIRST = "6개 일치 (2,000,000,000원) - "
    }
}