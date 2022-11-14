package lotto

class ValueInput {

    fun price(): Int {
        println(REQUIRE_MESSAGE_LOTTO_PRICE)
        val input: String = readLine()!!
        ValueInspection().price(input)
        return input.toInt()
    }
}