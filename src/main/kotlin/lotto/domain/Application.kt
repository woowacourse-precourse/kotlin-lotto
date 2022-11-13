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

    println(getWinningNumber())
    println(getBonusNumber())

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
    println("당첨 번호를 입력해주세요.")
    val numbers = mutableListOf<Int>()

    Console.readLine().split(",").map {
        val item = it.toInt()
        if(item !in 1..45) {
            println("[ERROR] 1부터 45 사이의 숫자만 입력해주세요.")
            throw IllegalArgumentException()
        }
        if(numbers.contains(item)){
            println("[ERROR] 중복되지 않는 숫자를 입력해주세요.")
            throw IllegalArgumentException()
        }
        numbers.add(item)
    }

    if(numbers.size != 6) {
        println("[ERROR] 당첨 번호는 6개여야 합니다.")
        throw IllegalArgumentException()
    }

    return numbers
}

// 보너스 번호를 입력 받는다.
fun getBonusNumber(): Int {
    println("보너스 번호를 입력해주세요.")
    val input = Console.readLine().toInt()
    if(input !in 1..45){
        println("[ERROR] 1부터 45 사이의 숫자만 입력해주세요.")
        throw IllegalArgumentException()
    }
    return input
}