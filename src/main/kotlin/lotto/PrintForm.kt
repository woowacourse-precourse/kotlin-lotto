package lotto

import java.text.DecimalFormat

class PrintForm {
    fun printUserInputMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun printUserBoughtLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printPleaseInputWinNumbers() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printPleaseInputBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printResultOfLotto(prizeType: EnumPrizeType, count: Int) {
        println(
            when (prizeType) {
                EnumPrizeType.FIRST -> "6개 일치 (${priceFormat(prizeType.price)}원) - ${count}개"
                EnumPrizeType.SECOND -> "5개 일치, 보너스 볼 일치 (${priceFormat(prizeType.price)}원) - ${count}개"
                EnumPrizeType.THIRD -> "5개 일치 (${priceFormat(prizeType.price)}원) - ${count}개"
                EnumPrizeType.FOURTH -> "4개 일치 (${priceFormat(prizeType.price)}원) - ${count}개"
                EnumPrizeType.FIFTH -> "3개 일치 (${priceFormat(prizeType.price)}원) - ${count}개"
            }
        )
    }

    private fun priceFormat(price: Int): String {
        return DecimalFormat("###,###").format(price)
    }

    fun printGainPercent(percent: Float) {
        println("총 수익률은 ${percent}%입니다.")
    }

    fun printError(errorType: ErrorType) {
        println("${Error.errorHeader} ${EnumError().checkErrorType(errorType)}")
    }
}