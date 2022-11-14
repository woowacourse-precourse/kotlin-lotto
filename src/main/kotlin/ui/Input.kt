package ui

import camp.nextstep.edu.missionutils.Console
import data.*
import lotto.ValueInspection

class Input {
    private val inspection: ValueInspection = ValueInspection()

    fun price(): Int {
        val input: String = Console.readLine()
        println(REQUIRE_MESSAGE_LOTTO_PRICE)
        inspection.price(input)
        return input.toInt()
    }

    fun jackpot(): List<Int> {
        val input: String = Console.readLine()
        println(REQUIRE_MESSAGE_JACKPOT_NUMBER)
        inspection.jackpot(input)
        return input.split(",").map { it.toInt() }
    }

    fun bonus(): Int {
        val input: String = Console.readLine()
        println(REQUIRE_MESSAGE_BONUS_NUMBER)
        inspection.bonus(input)
        return input.toInt()
    }

}