package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        exceptionsByUserInputTextType(UserInputTextType.LOTTO_NUMBERS, numbers)
    }

}

class PurchaseAmount(private val paymentCost: Int = 0) {
    init {
        exceptionsByUserInputTextType(UserInputTextType.PURCHASE_AMOUNT, paymentCost = paymentCost)
    }
}

class BonusNumber(private val bonusNumber: Int = 0, private val numbers: List<Int> = emptyList()) {
    init {
        exceptionsByUserInputTextType(UserInputTextType.BONUS_NUMBER, numbers, bonusNumber = bonusNumber)
    }
}

fun getUserInputText(): String = Console.readLine()

fun getLottoNumbers(
    startNumber: Int = 1, endNumber: Int = 45, count: Int = 6
): MutableList<Int> = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count)

fun getLottoNumbersCount(userInputTotalPrice: Int, numberToDivide: Int) =
    userInputTotalPrice.div(numberToDivide)

fun getLottoNumbersList(lottoNumbersCount: Int): MutableList<List<Int>> {
    val lottoNumbersList = mutableListOf<List<Int>>()
    repeat(lottoNumbersCount) {
        lottoNumbersList.add(getLottoNumbers())
    }
    return lottoNumbersList
}

fun setSplitUserInputNumbers(standard: String = ","): List<Int> {
    return getUserInputText().split(standard).map { number ->
        requireNotNull(number.toIntOrNull()) { ErrorFormatText.ENTER_ACCORDING_TO_THE_FORMAT.errorText }
        number.toInt()
    }
}

fun getNumberOfWinningNumbers(
    splitUserInputNumber: List<Int>, lottoNumberList: List<Int>, bonusNumber: Int
): Int {
    var numberOfWinningNumbers = 0
    for (i in splitUserInputNumber) {
        if (lottoNumberList.contains(i)) numberOfWinningNumbers++
    }
    return if (numberOfWinningNumbers == 5 && isIncludeBonusNumber(bonusNumber, lottoNumberList))
        8 else numberOfWinningNumbers
}

fun isIncludeBonusNumber(bonusNumber: Int, lottoNumberList: List<Int>) = lottoNumberList.contains(bonusNumber)

fun getListOfNumberOfWinningNumbers(
    lottoNumbersList: MutableList<List<Int>>, splitUserInputNumbers: List<Int>, bonusNumber: Int
): MutableList<Int> {
    val listOfNumberOfWinningNumbers = mutableListOf<Int>()
    lottoNumbersList.map { lottoNumbers ->
        listOfNumberOfWinningNumbers.add(getNumberOfWinningNumbers(splitUserInputNumbers, lottoNumbers, bonusNumber))
    }
    return listOfNumberOfWinningNumbers
}

fun getTotalRevenue(
    getListOfNumberOfWinningNumbers: MutableList<Int>
): Long {
    var totalRevenue = 0L
    getListOfNumberOfWinningNumbers.map {
        totalRevenue += when (it) {
            BaseNumber.SIX.number -> BaseNumber.SIX_WINNING_NUMBERS_COMPENSATION.number
            BaseNumber.FIVE_BONUS.number -> BaseNumber.FIVE_WINNING_NUMBERS_AND_BONUS_COMPENSATION.number
            BaseNumber.FIVE.number -> BaseNumber.FIVE_WINNING_NUMBERS_COMPENSATION.number
            BaseNumber.FOUR.number -> BaseNumber.FOUR_WINNING_NUMBERS_COMPENSATION.number
            BaseNumber.THREE.number -> BaseNumber.THREE_WINNING_NUMBERS_COMPENSATION.number
            else -> 0
        }
    }
    return totalRevenue
}

fun setTotalReturnFormat(totalRevenue: Double, totalPrice: Double): String =
    String.format("%.1f%%", totalRevenue / totalPrice * 100)


fun lottoGame() {
    println(GameGuideText.ENTER_PURCHASE_AMOUNT.guideText)
    val purchaseAmount = getUserInputText()
    requireNotNull(purchaseAmount.toIntOrNull()) { ErrorFormatText.ENTER_ACCORDING_TO_THE_FORMAT.errorText }
    PurchaseAmount(purchaseAmount.toInt())
    val lottoNumbersCount = getLottoNumbersCount(purchaseAmount.toInt(), numberToDivide = BaseNumber.LOTTO_PRICE.number)
    println("${lottoNumbersCount}개를 구매했습니다.")
    val lottoNumbersList = getLottoNumbersList(lottoNumbersCount)
    for (lottoNumber in lottoNumbersList) {
        println(lottoNumber)
    }
    println(GameGuideText.ENTER_WINNING_NUMBER.guideText)
    val userInputNumbers = setSplitUserInputNumbers()
    Lotto(userInputNumbers)
    println(GameGuideText.ENTER_BONUS_NUMBER.guideText)
    val bonusNumber = getUserInputText()
    requireNotNull(bonusNumber.toIntOrNull()) { ErrorFormatText.ENTER_ACCORDING_TO_THE_FORMAT.errorText }
    BonusNumber(numbers = userInputNumbers, bonusNumber = bonusNumber.toInt())
    val listOfNumberOfWinningNumbers =
        getListOfNumberOfWinningNumbers(lottoNumbersList, userInputNumbers, bonusNumber.toInt())
    println(GameGuideText.WINNING_STATS.guideText)
    println(GameGuideText.LINE.guideText)
    println(getWinningStatistics(WinningStatistics.THREE_WINNING_NUMBERS, listOfNumberOfWinningNumbers))
    println(getWinningStatistics(WinningStatistics.FOUR_WINNING_NUMBERS, listOfNumberOfWinningNumbers))
    println(getWinningStatistics(WinningStatistics.FIVE_WINNING_NUMBERS, listOfNumberOfWinningNumbers))
    println(getWinningStatistics(WinningStatistics.FIVE_BONUS_WINNING_NUMBERS, listOfNumberOfWinningNumbers))
    println(getWinningStatistics(WinningStatistics.SIX_WINNING_NUMBERS, listOfNumberOfWinningNumbers))
    println(
        getWinningStatistics(
            WinningStatistics.TOTAL_RETURN_FORMAT,
            listOfNumberOfWinningNumbers,
            purchaseAmount.toInt()
        )
    )
}


