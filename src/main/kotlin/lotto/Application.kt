package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val price = getPurchasePrice()
    publishLottoNumbers(price)
}

// 기능 1번
fun isNumber(string: String){
    if(string.toIntOrNull() == null)
        throw IllegalArgumentException("[ERROR] 구매 금액은 공백 없이 정수 형태여야 합니다.")
}

fun isThousands(number: String) {
    if (number.toInt() % 1000 != 0)
        throw IllegalArgumentException("[ERROR] 구매 금액은 천 단위의 수여야 합니다.")
}

fun isPositiveNumber(number: String) {
    if (number.toInt() <= 0)
        throw IllegalArgumentException("[ERROR] 구매 금액은 0보다 큰 수여야 합니다.")
}

fun isSatisfyPriceConditions(string: String) {
    isNumber(string)
    isThousands(string)
    isPositiveNumber(string)
}

fun printEnterPurchasePriceMessage() = println("구매금액을 입력해주세요.")

fun enterPurchasePrice(): String {
    printEnterPurchasePriceMessage()

    return Console.readLine()
}

fun getPurchasePrice(): Int {
    val purchasePrice = enterPurchasePrice()

    isSatisfyPriceConditions(purchasePrice)

    return purchasePrice.toInt()
}

// 기능 2번
fun getLottoCount(price: Int) = price / 1000

fun printLottoPurchaseCountMessage(price: Int) = println("${getLottoCount(price)}개를 구매했습니다.")

fun purchaseLotto() {
    printEnterPurchasePriceMessage()
    val price = getPurchasePrice()
    printLottoPurchaseCountMessage(price)
}

fun generateLottoNumber(): MutableList<Int> = Randoms.pickUniqueNumbersInRange(1,45,6)

fun generateLottoNumbers(price: Int): ArrayList<MutableList<Int>> {
    val lottoNumbers = arrayListOf<MutableList<Int>>()
    val size = getLottoCount(price)

    for (i in 0 until size) lottoNumbers.add(generateLottoNumber())

    return lottoNumbers
}

fun printNumbersByAscending(numbers: ArrayList<MutableList<Int>>) {
    for (i in numbers.indices) println("${numbers[i].sorted()}")
}

fun publishLottoNumbers(price: Int): ArrayList<MutableList<Int>> {
    val lottoNumbers = generateLottoNumbers(price)

    printNumbersByAscending(lottoNumbers)

    return lottoNumbers
}

// 기능 3번
fun wordToNumber(word: String) = word.toInt()

fun wordsToNumber(words: List<String>): MutableList<Int> {
    val number = mutableListOf<Int>()

    for (i in words.indices)
        number.add(wordToNumber(words[i]))

    return number
}

fun splitToWinningNumberPattern(string: String) = string.split(",")

fun isRightPatternOfWinningNumber(string: String) {
    if (splitToWinningNumberPattern(string).isNullOrEmpty() == null)
        throw IllegalArgumentException("[ERROR] 당첨 번호는 정해진 입력 형식(쉼표 구분)을 지켜야 합니다.")
}

fun isNumberOfWinningNumber(string: String) {
    val number = splitToWinningNumberPattern(string)

    for (i in number.indices)
        isNumber(number[i])
}

fun isRightRangeOfWinningBonusNumber(string: String) {
    if (string.toInt() !in 1..45)
        throw IllegalArgumentException("[ERROR] 당첨 번호(보너스 번호)는 1부터 45까지의 수여야 합니다.")
}

fun isRightRangeOfWinningNumber(string: String) {
    val number = splitToWinningNumberPattern(string)

    for (i in number.indices)
        isRightRangeOfWinningBonusNumber(number[i])
}

fun isRightCountOfWinningNumber(string: String) {
    val number = splitToWinningNumberPattern(string)

    if (number.size != 6)
        throw IllegalArgumentException("[ERROR] 당첨 번호는 6개의 수여야 합니다.")
}

fun isNotDuplicateOfWinningNumber(string: String) {
    val number = splitToWinningNumberPattern(string)

    if (number.size != number.distinct().size)
        throw IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 수여야 합니다.")
}

fun isNotDuplicateOfBonusNumber(string: String, winningNumber: MutableList<Int>) {
    if (winningNumber.contains(string.toInt()))
        throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 수여야 합니다.")
}

fun isSatisfyWinningNumberConditions(string: String) {
    isRightPatternOfWinningNumber(string)
    isNumberOfWinningNumber(string)
    isRightRangeOfWinningNumber(string)
    isRightCountOfWinningNumber(string)
    isNotDuplicateOfWinningNumber(string)
}

fun isSatisfyBonusNumberConditions(string: String, winningNumber: MutableList<Int>) {
    isNumber(string)
    isRightRangeOfWinningBonusNumber(string)
    isNotDuplicateOfBonusNumber(string, winningNumber)
}

fun printEnterWinningNumberMessage() = println("당첨 번호를 입력해 주세요.")

fun printEnterBonusNumberMessage() = println("보너스 번호를 입력해 주세요.")

fun enterWinningNumber(): String {
    printEnterWinningNumberMessage()

    return Console.readLine()
}

fun enterBonusNumber(): String {
    printEnterBonusNumberMessage()

    return Console.readLine()
}

fun getWinningNumberOnly(): MutableList<Int> {
    val winningNumber = enterWinningNumber()

    isSatisfyWinningNumberConditions(winningNumber)

    return wordsToNumber(splitToWinningNumberPattern(winningNumber))
}

fun getWinningBonusNumbers(): MutableList<Int> {
    val winningNumber = getWinningNumberOnly()
    val bonusNumber = enterBonusNumber()

    isSatisfyBonusNumberConditions(bonusNumber, winningNumber)
    winningNumber.add(wordToNumber(bonusNumber))

    return winningNumber
}