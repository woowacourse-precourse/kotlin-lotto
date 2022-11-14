package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBuyer {
    fun inputLottoPurchasePrice(): Int {// 로또 구입 금액
        println("구입금액을 입력해 주세요.")
        val inputPrice = Console.readLine()//String
        return inputPrice.toInt()
    }
}