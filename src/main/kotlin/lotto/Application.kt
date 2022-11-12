package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {

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

fun getPurchasePrice(): Int {
    val purchasePrice = Console.readLine()

    return if (isSatisfyPriceConditions(purchasePrice)) purchasePrice.toInt()
    else throw IllegalArgumentException("[ERROR] 구매 금액은 공백 없이 천 단위의 수여야 합니다.")
}

