package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    var money = try {
        Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        print("[ERROR] 숫자만 입력해 주세요.")
        println("구입금액을 입력해 주세요.")
        Console.readLine().toInt()
    }

    if ((money % 1000) != 0) {
        throw IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.")
    }

    var lottoCount = money / 1000

    println("\n${lottoCount}개를 구매했습니다.")
}
