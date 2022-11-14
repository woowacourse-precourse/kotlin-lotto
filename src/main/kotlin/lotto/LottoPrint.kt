package lotto

import camp.nextstep.edu.missionutils.Console

class LottoPrint {
    private val lg = LottoLogic()

    fun lottoPurchaseAmount(){
        println("구매금액을 입력해 주세요.")
        val userPurchaseAmount = Console.readLine()
        var lottoCount = 0
        try {
            lottoCount = userPurchaseAmount.toInt()
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.")
        }
        lg.lottoPurchaseAmount(lottoCount)
    }
}