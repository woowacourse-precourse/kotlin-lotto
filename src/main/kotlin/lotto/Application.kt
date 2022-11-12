package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

lateinit var consumer: Consumer
fun main() {
    orderLotto()
    printConsumerLotto()
}

private fun orderLotto() {
    val money = Console.readLine()
    try {
        consumer = Consumer(money.toInt())
        consumer.buyLotto()
        println("${money.toInt()/1000}개를 구매했습니다.")
    }catch (e : IllegalArgumentException){
        print("[ERROR] "+ e.message)
    }
}

private fun printConsumerLotto(){
    for(lottoCount in consumer.myLotto){
        println(lottoCount)
    }
}

