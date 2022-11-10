package lotto

import camp.nextstep.edu.missionutils.Console

lateinit var consumer: Consumer
fun main() {
    orderLotto()
}

private fun orderLotto() {
    val money = Console.readLine()
    consumer = Consumer(money.toInt())
    consumer.buyLotto()
}

