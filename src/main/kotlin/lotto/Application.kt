package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    var money = try {
        Console.readLine().toInt()
    } catch (e : NumberFormatException) {
        print("[ERROR] 숫자만 입력해 주세요.")
        println("구입금액을 입력해 주세요.")
        Console.readLine().toInt()
    }
    
}
