package lotto

class Judgment {

    val LOTTO_PRICE = 1000

    fun checkPurchaseAmount(input: String): Boolean {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 구매 금액을 숫자 형태로 입력해야 합니다.")
        }
        if (input.toInt() % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 구매 금액을 1000원 단위로 입력하세요.")
        }
        return true
    }

    fun getPurchaseNumber(input: String): Int {
        var money = input.toInt()
        return money / LOTTO_PRICE
    }
}