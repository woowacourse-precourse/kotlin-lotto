package lotto

import camp.nextstep.edu.missionutils.Console

class InputWinningLottoNum {

    fun inputWinningLottoNum(){
        println("당첨 번호를 입력해주세요.")
        val lottoNum = Console.readLine()
        lottoNum.split(",")
    }

    fun inputBonusLottoNum(){
        println("보너스 번호를 입력해주세요.")

        val bonusNum = Console.readLine()

    }
}