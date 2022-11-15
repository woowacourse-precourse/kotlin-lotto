package lotto.input

import lotto.util.Input

interface InputBonus {
    fun inputBonusNumber(lottoNumber: String): Int
    fun checkBonusStandard(userInputNumber: String?, lottoNumbers: String)
}

class InputBonusImpl : InputBonus {
    private val userInputNumber = Input().inputUser()
    override fun inputBonusNumber(lottoNumber: String): Int {
        print("보너스 번호를 입력해 주세요.")
        checkBonusStandard(userInputNumber, lottoNumber)
        println(userInputNumber.toInt())
        return userInputNumber.toInt()
    }

    override fun checkBonusStandard(userInputNumber: String?, lottoNumbers: String) {
        userInputNumber ?: throw IllegalArgumentException()
        val lottoOverlapCheck = mutableListOf<String>()
        val lottoNumber = lottoNumbers.split(",")
        if (userInputNumber.toInt() >= 46 || userInputNumber.toInt() < 1) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
        lottoOverlapCheck.add(userInputNumber)
        lotto.util.InputValidateReal().checkInputMessagePatten(lottoOverlapCheck)
        if (lottoOverlapCheck.size != 1 || lottoNumber.contains(lottoOverlapCheck[0])) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}