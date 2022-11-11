package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val inputVerifier = InputVerifier()

    println("구입금액을 입력해 주세요.")
    val amountOfPurchase = Console.readLine().toInt()
    inputVerifier.validateAmountOfPurchase(amountOfPurchase)
}
