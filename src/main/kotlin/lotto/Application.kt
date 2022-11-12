package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    purchaseLotto()
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



