package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val price = enterPurchasePrice()
    print(publishLottoNumbers(price))
}

fun isNumber(string: String) = string.toIntOrNull() != null

fun isThousands(number: String) = number.toInt() % 1000 == 0

fun isPositiveNumber(number: String) = number.toInt() >= 0

fun isNotWhiteSpace(string: String) = !string.contains(" ")

fun isSatisfyPriceConditions(string: String) =
        isNumber(string) &&
        isThousands(string) &&
        isPositiveNumber(string) &&
        isNotWhiteSpace(string)

fun printEnterPriceMessage() = print("구매금액을 입력해주세요.\n")

fun enterPurchasePrice(): Int {
    val purchasePrice = Console.readLine()

    return if (isSatisfyPriceConditions(purchasePrice)) purchasePrice.toInt()
    else throw IllegalArgumentException("[ERROR] 구매 금액은 공백 없이 천 단위의 수여야 합니다.")
}

fun printLottoPurchaseCountMessage(price: Int) = print("${price/1000}개를 구매했습니다.")

fun purchaseLotto() {
    printEnterPriceMessage()
    val price = enterPurchasePrice()
    printLottoPurchaseCountMessage(price)
}

fun addNotDuplicateNumber(number: Int, numbers: MutableList<Int>) {
    if (!numbers.contains(number)) numbers.add(number)
}

fun generateRandomNumber() = Randoms.pickNumberInRange(1,45)

fun generateLottoNumber(): MutableList<Int> {
    val numbers = mutableListOf<Int>()

    while (numbers.size != 6) {
        val number = generateRandomNumber()
        addNotDuplicateNumber(number, numbers)
    }

    return numbers
}

fun publishLottoNumbers(price: Int): ArrayList<MutableList<Int>> {
    val lottoNumbers = arrayListOf<MutableList<Int>>()
    val size = price/1000

    for (i in 0 until size) lottoNumbers.add(generateLottoNumber())

    return lottoNumbers
}



