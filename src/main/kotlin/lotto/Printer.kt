package lotto

class Printer {
    fun printAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottoCountMessage(count: Int) {
        println("\n${count}개를 구매했습니다.")
    }

    fun printBoughtLottoList(lotteries: List<List<Int>>) {
        lotteries.forEach { list ->
            println(list)
        }
    }

    fun printWinningNumberMessage() {
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumberMessage() {
        println("\n보너스 번호를 입력해 주세요.")
    }

    fun printWinStaticMessage() {
        println("\n당첨 통계\n---")
    }

    fun printLottoResult(result: List<LottoResultState>) {
        println(
            "3개 일치 (5,000원) - ${result.count{it==LottoResultState.FIFTH}}개\n" +
            "4개 일치 (50,000원) - ${result.count{it==LottoResultState.FOURTH}}개\n" +
            "5개 일치 (1,500,000원) - ${result.count{it==LottoResultState.THIRD}}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.count{it==LottoResultState.SECOND}}개\n" +
            "6개 일치 (2,000,000,000원) - ${result.count{it==LottoResultState.FIRST}}개"
        )
    }

    companion object {
        fun printError(errorMessage: String) {
            println("[ERROR] $errorMessage")
        }
    }
}