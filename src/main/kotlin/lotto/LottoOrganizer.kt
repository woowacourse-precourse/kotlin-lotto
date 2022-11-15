package lotto

import camp.nextstep.edu.missionutils.Console

class LottoOrganizer(private val producedLottoNumbers: MutableList<List<Int>>) {


    fun inputWinLottoNumber() {
        val userInput = Console.readLine()
    }


    fun inputBonusLottoNumber() {
        val userInput = Console.readLine()
    }


    fun printInputLottoWinNumber() {
        println(LottoProcessStatement.INPUT_LOTTO_WIN_NUMBER)
    }

    fun printInputLottoBonusNumber() {
        println(LottoProcessStatement.INPUT_LOTTO_BONUS_NUMBER)
    }

}