package lotto

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

const val userInputMsg = "구입금액을 입력해 주세요."
const val userBoughtLottoCount = "%d개를 구매했습니다."
const val LOTTO_EACH_PRICE = 1000
const val INPUT_ERROR_CODE = 999

private var userInputPrice = 0 //추후에 수익률에 재사용하므로 전역변수로 설정

fun main() {
    getUserInputPrice()
}
private fun getUserInputPrice() {
    println(userInputMsg)
    userInputPrice = UserInputPrice(Console.readLine()).checkUserInputPriceRegexAndTranslateToInt()
    if(userInputPrice != INPUT_ERROR_CODE) {
        val randomLottoNumbers = RandomNumbers(userInputPrice).getRandomLottoNumbers()
    }
}