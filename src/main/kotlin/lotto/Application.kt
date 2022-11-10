package lotto

import camp.nextstep.edu.missionutils.Console

const val INTRODUCE_MESSAGE = "구입금액을 입력해 주세요."
fun main() {
    displayIntroduceGuideMessage()
    val userBudget = getUserBudget()
}

fun getUserBudget(): String = Console.readLine()
fun displayIntroduceGuideMessage() = println(INTRODUCE_MESSAGE)