package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun getMoney(): String {
        println(INPUT_MONEY_GUIDE)
        return get()
    }

    fun getWinningNumbers(): String {
        println(INPUT_WINNING_NUMBERS_GUIDE)
        return get()
    }

    private fun get(): String {
        return Console.readLine()
    }

    companion object {
        const val INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요."
    }
}