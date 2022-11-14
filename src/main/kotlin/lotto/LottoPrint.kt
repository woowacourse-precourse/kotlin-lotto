package lotto

class LottoPrint {
    fun printPaymentMessage() {
        println("구입금액을 입력해주세요")
    }

    fun printWinnerNumberMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printBonusNumberMessage() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printPurchaseLottoInfo(lottosNumbers: List<List<Int>>) {
        println("${lottosNumbers.size}개를 구매했습니다.")
        lottosNumbers.forEach {
            println("$it")
        }
    }

    fun printLottosResult(lottosResult: List<Int>, earningsPercent: Double) {
        println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - ${lottosResult[0]}개\n" +
                "4개 일치 (50,000원) - ${lottosResult[1]}개\n" +
                "5개 일치 (1,500,000원) - ${lottosResult[2]}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottosResult[3]}개\n" +
                "6개 일치 (2,000,000,000원) - ${lottosResult[4]}개\n" +
                "총 수익률은 ${String.format("%.1f",earningsPercent)}%입니다.")
    }
}