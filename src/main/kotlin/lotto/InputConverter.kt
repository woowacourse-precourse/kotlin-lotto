package lotto

class InputConverter {
    fun convertToPurchaseCount(input: String): Int = input.toInt() % LottoSeller.LOTTO_SELL_PRICE
    fun convertToInt(input: String): Int = input.toInt()
    fun convertSeparateComma(input: String): List<Int> {
        val numbers = input.split(",")
        return numbers.map { it.toInt() }
    }
}