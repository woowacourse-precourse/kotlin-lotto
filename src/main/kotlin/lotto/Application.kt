package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val price = enterPurchasePrice()
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

fun printEnterPriceMessage() = println("구매금액을 입력해주세요.")

fun enterPurchasePrice(): Int {
    val purchasePrice = Console.readLine()

    isSatisfyPriceConditions(purchasePrice)

    return purchasePrice.toInt()
}

// 기능 2번
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