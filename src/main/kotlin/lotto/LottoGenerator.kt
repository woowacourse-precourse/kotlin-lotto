package lotto

import camp.nextstep.edu.missionutils.Console

class LottoGenerator {
    fun inputMoney() : Int{
        println("구입금액을 입력해 주세요.")
        var money = Console.readLine()

        LottoError.checkMoneyError(money)

        val numberOfLotto = money.toInt() / 1000
        println("\n$numberOfLotto" + "개를 구매했습니다.")

        return money.toInt()
    }
}