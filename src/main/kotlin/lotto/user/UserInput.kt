package lotto.user

import camp.nextstep.edu.missionutils.Console

fun inputUserMoney(): String {
    print("구입금액을 입력해 주세요.")
    val userInputMoney = Console.readLine()
    return userInputMoney.toString()
}