package lotto

import camp.nextstep.edu.missionutils.Console

const val INTRODUCE_MESSAGE = "구입금액을 입력해 주세요."
const val SUCCESS_BUY_LOTTO_MESSAGE = "개를 구매했습니다."
fun main() {
    displayIntroduceGuideMessage()
    val userBudget = getUserBudget()

    val boughtLottoCount = userBudget.toInt() / 1000
    displaySuccessBuyLottoGuideMessage(boughtLottoCount)
}

fun getUserBudget(): String = Console.readLine()
fun displayIntroduceGuideMessage() = println(INTRODUCE_MESSAGE)
fun displaySuccessBuyLottoGuideMessage(boughtLottoCount: Int) = println("$boughtLottoCount$SUCCESS_BUY_LOTTO_MESSAGE")