package lotto.view

import lotto.domain.money.Money
import lotto.domain.prize.LottoPrize

class OutputView {
    fun printInputPurchaseAmount() {
        println("구입금액을 입력해주세요.")
    }

    fun printLottoPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printInputWinningNumbers() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printWinningStatistics(prizeCount: Map<LottoPrize, Int>) {
        println("당첨 통계")
        println("---")
        val lottoPrizeValues = getLottoPrizeValues()
        lottoPrizeValues.forEach { lottoPrize ->
            println(getPrizeCountStatistics(lottoPrize, prizeCount[lottoPrize] ?: 0))
        }
    }

    fun getPrizeCountStatistics(prize: LottoPrize, prizeCount: Int): String {
        val moneyUnit = Money(prize.winningAmount.toString()).changeMoneyUnit()
        if (!prize.isMatchedLottoNumbers) {
            return "${prize.matchedCount}개 일치 (${moneyUnit}원) - ${prizeCount}개"
        }
        return "${prize.matchedCount}개 일치, 보너스 볼 일치 (${moneyUnit}원) - ${prizeCount}개 "
    }

    fun printPrifitRate(profitRate: String) {
        println("총 수익률은 ${profitRate}%입니다.")
    }

    private fun getLottoPrizeValues(): List<LottoPrize> =
        LottoPrize.values()
            .filter { prize ->
                prize != LottoPrize.NO_WINNING_AMOUNT
            }.reversed()
}