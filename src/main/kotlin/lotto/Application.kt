package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = inputMoney()
    val lottoCount = printLottoConut(money)
    val allLotto = publishLotto(lottoCount)
    val answerNum = inputWinningNumber()
    val bonusNum = inputBonusNumber()

    var bonusCount = 0

    var answerList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0)

    for (i in 0 until lottoCount) {
        val lottos = allLotto[i].toList()
        var answerCount = 0
        for (j in 0..5) {
            val lottoNum = lottos[j]
            for (k in 0..5) {
                if (answerNum[k].toInt() == lottoNum) {
                    answerCount++
                }
                if (bonusNum == lottoNum) {
                    bonusCount = 1
                }
            }
        }
        if (answerCount != 0) {
            answerList[answerCount] = answerList[answerCount] + 1
        }
        if (answerCount == 5 && bonusCount == 1) {
            answerList[7] = answerList[7] + 1
        }
    }

    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${answerList[3]}개")
    println("4개 일치 (50,000원) - ${answerList[4]}개")
    println("5개 일치 (1,500,000원) - ${answerList[5]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${answerList[7]}개")
    println("6개 일치 (2,000,000,000원) - ${answerList[6]}개")

    var totalPrice = 5000 * answerList[3] + 50000 * answerList[4] + 1500000 * answerList[5]
    +2000000000 * answerList[6] + 30000000 * answerList[7]

    var percent = totalPrice / money.toFloat() * 100

    println("총 수익률은 " + "%.1f".format(percent) + "%입니다.")
}

fun inputMoney(): Int {
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
    return money
}

fun printLottoConut(money: Int): Int {
    var lottoCount = money / 1000
    println("\n${lottoCount}개를 구매했습니다.")
    return lottoCount
}

fun publishLotto(lottoCount: Int): Array<IntArray> {
    var allLotto = Array<IntArray>(lottoCount) { IntArray(6) }
    for (i in 0 until lottoCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 20, 6)
        Lotto(numbers)
        println(numbers.sorted())
        allLotto[i] = numbers.toIntArray()
    }
    return allLotto
}

fun inputWinningNumber(): List<String> {
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
    return answerNum
}

fun inputBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")
    var bonusNum = Console.readLine().toInt()
    if (bonusNum < 1 || bonusNum > 45) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    return bonusNum
}