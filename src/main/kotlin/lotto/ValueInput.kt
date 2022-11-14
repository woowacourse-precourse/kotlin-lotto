package lotto

class ValueInput {
    private val input: String = readln()
    private val inspection: ValueInspection = ValueInspection()

    fun price(): Int {
        println(REQUIRE_MESSAGE_LOTTO_PRICE)
        inspection.price(input)
        return input.toInt()
    }

    fun jackpot(): List<Int> {
        println(REQUIRE_MESSAGE_JACKPOT_NUMBER)
        inspection.jackpot(input)
        return input.split(",").map { it.toInt() }
    }

    fun bonus(): Int {
        println(REQUIRE_MESSAGE_BONUS_NUMBER)
        inspection.bonus(input)
        return input.toInt()
    }

}