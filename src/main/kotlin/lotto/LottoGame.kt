package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Util
class LottoGame {
    lateinit var lottoNum : Lotto
    val util = Util()
    fun inputLottoNum():List<Int>{
        println("당첨 번호를 입력해 주세요.")
        var input = Console.readLine()
        util.isRightForm(input)
        return util.changeInputToLotto(input)
    }

    fun inputBonusNum():Int{
        println("보너스 번호를 입력해 주세요.")
        var input = Console.readLine()
        util.checkBonusNum(input, lottoNum)
        var bonus = input.toInt()
        return bonus
    }

    fun playGame(){

    }
}