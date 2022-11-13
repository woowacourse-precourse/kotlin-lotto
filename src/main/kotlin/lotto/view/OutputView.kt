package lotto.view

class OutputView {
    fun printInputPurchaseAmount() {
        println("구입금액을 입력해주세요.")
    }

    fun printLottoPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        lottoNumbers.forEach { lotto ->
            println(lotto.toString())
        }
    }

    fun printInputWinningNumbers() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printWinningStatistics(matchedCount: Int, money: String, prizeCount: Int) {
        """
        당첨통계
        ---
        """.trimIndent()
        printStatistics(matchedCount, money, prizeCount)
    }

    fun printStatistics(matchedCount: Int, money: String, prizeCount: Int) {
        println("${matchedCount}개 일치 (${money}) - ${prizeCount}개")
    }

    fun printPrifitRate(profitRate: String) {
        println("총 수익률은 ${profitRate}%입니다.")
    }
}