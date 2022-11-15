package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val price = enterPurchasePrice()
    publishLottoNumbers(price)
}

fun isNumber(string: String) = string.toIntOrNull() != null

fun isThousands(number: String) = number.toInt() % 1000 == 0

fun isPositiveNumber(number: String) = number.toInt() > 0

fun isSatisfyPriceConditions(string: String) =
        isNumber(string) &&
        isThousands(string) &&
        isPositiveNumber(string)

fun printEnterPriceMessage() = println("구매금액을 입력해주세요.")

fun enterPurchasePrice(): Int {
    val purchasePrice = Console.readLine()

    if (!isSatisfyPriceConditions(purchasePrice))
        throw IllegalArgumentException("[ERROR] 구매 금액은 공백 없이 천 단위의 수를 입력해주세요.")

    return purchasePrice.toInt()
}

fun getLottoCount(price: Int) = price / 1000

fun printLottoPurchaseCountMessage(price: Int) = println("${getLottoCount(price)}개를 구매했습니다.")

fun purchaseLotto() {
    printEnterPriceMessage()
    val price = enterPurchasePrice()
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