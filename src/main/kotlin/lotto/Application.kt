package lotto

import lotto.View.MessageOutput
import lotto.Computer.NumberCreate
import lotto.User.UserInput

fun main() {
    MessageOutput().printStartMessage()
    val ticket = UserInput().buyPrice()
    var lottoList : MutableList<List<Int>> = ArrayList()
    for( i in 1..ticket){
        var numbers = NumberCreate()
        lottoList.add((numbers))
    }
    MessageOutput().printBuyMessage(ticket, lottoList)
}
