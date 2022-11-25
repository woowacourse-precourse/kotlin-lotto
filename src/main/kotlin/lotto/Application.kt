package lotto

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern


const val LOTTO_EACH_PRICE = 1000
const val INPUT_ERROR_CODE = 999
const val lottoPrizeRankCount = 5

private var userInputPrice = 0 //추후에 수익률에 재사용하므로 전역변수로 설정

fun main() {
    getUserInputPrice()
}

private fun getUserInputPrice() {
    PrintForm().printUserInputMoney()
    userInputPrice = UserInputPrice(Console.readLine()).checkUserInputPriceRegexAndTranslateToInt()
    if (userInputPrice != INPUT_ERROR_CODE) {
        val randomLottoNumbers = RandomNumbers(userInputPrice).getRandomLottoNumbers()
        val userInputWinNumbers = combineWinAndBonus()
        compareRandomAndUserWinNumbers(randomLottoNumbers, userInputWinNumbers)
    }
}

private fun combineWinAndBonus(): List<Int> {
    val userWinNumbers = getUserWinNumbers()
    val userBonusNumber = getUserBonusNumber(userWinNumbers)
    return convertStringListToIntList(userWinNumbers.plus(userBonusNumber))
}

private fun convertStringListToIntList(winNumbers: List<String>): List<Int> {
    return winNumbers.map { it.toInt() }
}

private fun getUserWinNumbers(): List<String> {
    PrintForm().printPleaseInputWinNumbers()
    return UserWinNumbers(Console.readLine()).checkUserWinNumberRegex()
}

private fun getUserBonusNumber(userWinNumbers: List<String>): String {
    PrintForm().printPleaseInputBonusNumber()
    return UserBonusNumber(userWinNumbers, Console.readLine()).getBonusNumberRegex()
}

private fun compareRandomAndUserWinNumbers(randomNumbers: List<List<Int>>, userWinNumbers: List<Int>) {
    val prizeList = mutableListOf<Int>()
    for (i in randomNumbers) {
        prizeList.add(Lotto(i).getUserWinNumbers(userWinNumbers))
    }
    convertPrizeListToPrizeCountList(prizeList)
}

private fun convertPrizeListToPrizeCountList(prizeList: List<Int>) {
    val prizeCountList = mutableListOf<Int>()
    for (i in 0 until lottoPrizeRankCount) {
        prizeCountList.add(prizeList.count { it == i })
    }
    LottoResults(userInputPrice, prizeCountList.reversed()).printPrizeResults()
}