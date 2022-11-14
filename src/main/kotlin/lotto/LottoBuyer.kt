package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBuyer {

    fun inputLottoPurchasePrice(): Int {// 로또 구입 금액
        println("구입금액을 입력해 주세요.")
        val inputPrice = Console.readLine()
        inputLottoPurchasePriceError(inputPrice)
        return inputPrice.toInt()
    }

    fun inputLottoPurchasePriceError(inputPrice: String) {// 로또 금액 예외처리
        when {
            inputPrice.toInt() < 1000 -> return throw IllegalArgumentException("[ERROR] 천원보다 적은 숫자 입니다.")
            inputPrice.toInt() % 1000 != 0 -> return throw IllegalArgumentException("[ERROR] 천원으로 나누어 떨어지지 않는 숫자입니다.")
        }
    }

}