package lotto
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun firstPay() : Int{
    var pay = 0
    println("구입금액을 입력해 주세요.")
    try {
        pay = readLine()!!.toInt()
    } catch (e : NumberFormatException){
        println("[ERROR] 입력된 금액이 올바른 금액이 아닙니다.")
    }
    require(pay % 1000 == 0){
        "[ERROR] 입력 금액이 1000원 단위가 아닙니다."
    }
    return pay
}



fun main() {
    TODO("프로그램 구현")
}
