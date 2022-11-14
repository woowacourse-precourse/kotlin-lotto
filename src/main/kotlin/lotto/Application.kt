package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import message.Message

var winnings: List<String> = listOf()

fun main() {
    val money = inputMoney()
    val lottoCount = Print().printLottoConut(money)
    val allLotto = publishLotto(lottoCount)
    winnings = inputWinningNumber()
    val bonusNum = inputBonusNumber()

    var winningCounts = mutableListOf<Int>()
    allLotto.forEach {
        winningCounts = Lotto(it.toList()).calculateLottoWin(lottoCount, allLotto, bonusNum)
    }

    Print().printWinningScore(winningCounts)
    Print().printWinningRate(winningCounts, money)
}

fun inputMoney(): Int {
    println(Message.INPUT_MONEY.message)
    var money = try {
        Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        print("[ERROR] 숫자만 입력해 주세요.")
        println("구입금액을 입력해 주세요.")
        Console.readLine().toInt()
    }
    checkInputMoneyIs1000(money)
    return money
}

fun checkInputMoneyIs1000(money: Int) {
    if ((money % 1000) != 0) {
        throw IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.")
    }
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
    println("\n${Message.INPUT_WINNING_NUM.message}")
    var winnings = Console.readLine().split(",")
    winnings.forEach {
        checkNumberScope(it.toInt())
    }
    for (i in 0..4) {
        for (j in i + 1..5) {
            if (winnings[i] == winnings[j]) {
                throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
            }
        }
    }
    return winnings
}

fun inputBonusNumber(): Int {
    println("\n${Message.INPUT_BONUS_NUM.message}")
    var bonusNum = Console.readLine().toInt()
    checkNumberScope(bonusNum)
    return bonusNum
}

fun checkNumberScope(num: Int) {
    if (num < 1 || num > 45) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}