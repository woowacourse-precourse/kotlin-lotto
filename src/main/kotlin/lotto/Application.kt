package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputVerifier = InputVerifier()

    println("구입금액을 입력해 주세요.")
    val amountOfPurchase = Console.readLine().toInt()
    inputVerifier.validateAmountOfPurchase(amountOfPurchase)

    val numberOfPurchase = amountOfPurchase.div(1000)
    println("${numberOfPurchase}개를 구매했습니다.")
    for (i in 0 until numberOfPurchase) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers.sorted())
    }
}
