package lotto.ui

import camp.nextstep.edu.missionutils.Console.readLine

object Input {

    fun getPrice(): String {
        print("구입금액을 입력해 주세요.\n")
        return readLine()
    }

}