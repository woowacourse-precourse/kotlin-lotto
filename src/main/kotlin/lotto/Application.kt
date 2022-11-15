package lotto

import lotto.View.MessageOutput
import lotto.Computer.NumberCreate
import lotto.User.UserInput

fun main() {
    MessageOutput().printStartMessage()
    val price = UserInput().buyPrice()
    NumberCreate()
}
