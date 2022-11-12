package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

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

    var allLotto = Array<IntArray>(lottoCount) { IntArray(6) }

    for (i in 0 until lottoCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 20, 6)

        for (i in 0..4) {
            for (j in i + 1..5) {
                if (numbers[i] == numbers[j]) {
                    throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
                }
            }
        }

        println(numbers.sorted())
        allLotto[i] = numbers.toIntArray()
    }

    println("\n당첨 번호를 입력해 주세요.")
    var answerNum = Console.readLine().split(",")
    answerNum.forEach {
        if (it.toInt() < 1 || it.toInt() > 45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
    
    for (i in 0..4) {
        for (j in i + 1..5) {
            if (answerNum[i] == answerNum[j]) {
                //예외처리
                throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
            }
        }
    }

    println("\n보너스 번호를 입력해 주세요.")
    var bonusNum = Console.readLine().toInt()
    if (bonusNum < 1 || bonusNum > 45) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

}
