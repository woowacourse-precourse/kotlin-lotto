package lotto.ui

import camp.nextstep.edu.missionutils.Console.readLine

class Input {

    fun getPrice(): String {
        println("구입금액을 입력해 주세요.")
        return readLine()
    }

    fun getLottoNumbers(): String {
        println("\n당첨 번호를 입력해 주세요.")
        return readLine()
    }

    fun getBonusNumber(): String {
        println("\n보너스 번호르 입력해 주세요.")
        return readLine()
    }

}