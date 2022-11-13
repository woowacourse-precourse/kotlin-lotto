package lotto.view

import camp.nextstep.edu.missionutils.Console

class LottoView {

    fun getInputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = Console.readLine()
        validMoneyMount(inputMoney)
        return inputMoney.toInt()
    }

    private fun validMoneyMount(inputMoney: String) {
        if (!isNumber(inputMoney) || inputMoney.toInt() % PRICE_PER_LOTTO != 0 || inputMoney.toInt() == 0) {
            throw IllegalArgumentException("[ERROR]: 1,000원 단위의 숫자로만 입력되어야 합니다.")
        }
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    companion object {
        const val PRICE_PER_LOTTO = 1000
    }
}