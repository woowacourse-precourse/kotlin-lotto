package lotto

class ValueInput {

    fun price(): Int {
        println(REQUIRE_MESSAGE_LOTTO_PRICE)

        val input: String = readln()
        ValueInspection().price(input)

        return input.toInt()
    }

    fun jackpot(): List<Int> {
        println(REQUIRE_MESSAGE_JACKPOT_NUMBER)

        val input: String = readln()
        ValueInspection().price(input)

        return input.split(",").map { it.toInt() }
    }

    
}