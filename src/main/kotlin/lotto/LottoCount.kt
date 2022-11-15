package lotto

import camp.nextstep.edu.missionutils.Console
import message.Message

class LottoCount {

    fun inputMoney(): Int {
        println(Message.INPUT_MONEY.message)
        var money = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            print("[ERROR] 숫자만 입력해 주세요.")
            println("구입금액을 입력해 주세요.")
            Console.readLine().toInt()
        }
        checkInputMoneyIs1000(money)
        return money
    }

    private fun checkInputMoneyIs1000(money: Int) {
        if ((money % 1000) != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.")
        }
    }

    fun printLottoConut(money: Int): Int {
        var lottoCount = money / 1000
        println("\n${lottoCount}${Message.COUNT.message}")
        return lottoCount
    }

}