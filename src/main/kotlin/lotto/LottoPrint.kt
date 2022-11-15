package lotto

import camp.nextstep.edu.missionutils.Console

class LottoPrint {
    private val lg = LottoLogic()
    private var count = 0
    fun lottoPurchaseAmount(){
        println("구매금액을 입력해 주세요.")
        val userPurchaseAmount = Console.readLine()
        var purchaseAmount = 0
        try {
            purchaseAmount = userPurchaseAmount.toInt()
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 범위 내 숫자를 입력하셔야 합니다.")
        }
        count = lg.lottoPurchaseAmount(purchaseAmount)
        lottoCount(count)
    }

    private fun lottoCount(count : Int) {
        println("${count}개를 구매했습니다.")
    }
}