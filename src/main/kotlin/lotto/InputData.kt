package lotto

import camp.nextstep.edu.missionutils.Console

class InputData {
    var inputMoney = 0
    var LottoNum = mutableListOf<Int>()
    var bonusNum = 0

    fun inputMoney(): Int {
        println("구입금앱을 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun validInputMoney(inputMoney : Int){
        if(inputMoney%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.")
        }
    }

    fun inputLottoNum(): MutableList<Int> {
        println("당첨 번호를 입력해 주세요.")
        val Lotto = Console.readLine()
        return makeLottoNum(Lotto)
    }


}