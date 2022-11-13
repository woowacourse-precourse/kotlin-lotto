package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해주세요")
    var lottoPay = Console.readLine()
    var lottoTicket : Int
    if(chkNum(lottoPay)){
        print("[ERROR] 숫자만 입력해주세요")
        throw NoSuchElementException()
    }
    if(lottoPay.toInt()%1000 != 0){
        println("[ERROR] 금액을 1000원 단위로 입력해주세요")
        throw IllegalArgumentException()
    }
}
fun chkNum(str: String) : Boolean {
    var temp: Char

    var result = false

    for (i in 0 until str.length) {
        temp = str.elementAt(i)
        if (temp.toInt() < 48 || temp.toInt() > 57) {
            result = true
        }
    }

    return result
}