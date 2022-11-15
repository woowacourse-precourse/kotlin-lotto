package lotto.ui

import lotto.data.Message

class GuideLotto {
    fun printEnterPayment() = println(Message.ENTER_PAYMENT.message)
    fun printLottoCount(lottoQuantity: Int) = println("${lottoQuantity}개를 구매했습니다.")
    fun printWinningNumber() = println(Message.ENTER_WINNING_NUMBER.message)
    fun printBonusNumber() = println(Message.ENTER_BOUNS_NUMBER.message)

    fun printLottoResult(rankResult: MutableMap<String, Int>) {
        println("\n당첨 통계\n" + "---")
        println(
            "3개 일치 (5,000원) - ${if (rankResult["5등"] == null) 0 else rankResult["5등"]}개\n" +
                    "4개 일치 (50,000원) - ${if (rankResult["4등"] == null) 0 else rankResult["4등"]}개\n" +
                    "5개 일치 (1,500,000원) - ${if (rankResult["3등"] == null) 0 else rankResult["3등"]}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${if (rankResult["2등"] == null) 0 else rankResult["2등"]}개\n" +
                    "6개 일치 (2,000,000,000원) - ${if (rankResult["1등"] == null) 0 else rankResult["1등"]}개"
        )
    }

    fun printIncomeRate(income: Float) {
        println("총 수익률은 $income%입니다.")
    }
}