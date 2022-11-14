package lotto

fun main() {
    // 1. 사용자 입력 받기
    // 로또 구입 금액 입력
    // 1000원 = 1장
    println("구매금액을 입력해 주세요.")
    val userPayMoney = readLine()!!.toInt()
    val userAmountTobuy = userPayMoney / 1000
}
