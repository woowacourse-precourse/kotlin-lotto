package lotto.domain

import camp.nextstep.edu.missionutils.Console

fun main() {
    val tryNumber = getTryNumber()
    println("${tryNumber}를 구매했습니다.")
    for(i in 0 until tryNumber){
        val generator = NumberGenerator()
        val numbers = generator.createLottoNumber()
        println(numbers)
    }
}

// 1000원 단위의 구입 금액을 입력 받는다.
fun getTryNumber(): Int {
    println("구입 금액을 입력해주세요.")
    val money = Console.readLine().toInt()
    if(money % 1000 != 0) {
        println("[ERROR] 1000원 단위의 금액만 입력해주세요.")
        throw IllegalArgumentException()
    }
    return money / 1000
}

// 쉼표로 구분된 당첨 번호를 입력 받는다.
fun getWinningNumber(): List<Int> {
    return emptyList()
}

// 보너스 번호를 입력 받는다.
fun getBonusNumber(): Int {
    return 0
}