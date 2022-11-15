package lotto.input

import lotto.util.Input
import lotto.util.InputValidateReal
import lotto.util.OutputMessage

interface InputBonus {
    fun inputBonusNumber(lottoNumber: String): Int
    fun checkBonusStandard(userInputNumber: String?, lottoNumbers: String)
}

class InputBonusReal : InputBonus {
    override fun inputBonusNumber(lottoNumber: String): Int {
        print("보너스 번호를 입력해 주세요.")
        OutputMessage().bonusMsg()
        val userInputNumber = Input().inputUser()
        checkBonusStandard(userInputNumber, lottoNumber)
        println(userInputNumber.toInt())
        return userInputNumber.toInt()
    }

    override fun checkBonusStandard(userInputNumber: String?, lottoNumbers: String) {
        userInputNumber ?: throw IllegalArgumentException()
        val lottoOverlapCheck = mutableListOf<String>()
        val lottoNumber = lottoNumbers.split(",")
        lottoOverlapCheck.add(userInputNumber)
        InputValidateReal().checkInputMessagePatten(lottoOverlapCheck)
        if (userInputNumber.toInt() >= 46 || userInputNumber.toInt() < 1) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
        if (lottoOverlapCheck.size != 1 || lottoNumber.contains(lottoOverlapCheck[0])) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}