package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import message.Message
import message.ScoreMessage

var winnings: List<String> = listOf()

fun main() {
    val money = inputMoney()
    val lottoCount = printLottoConut(money)
    val allLotto = publishLotto(lottoCount)
    winnings = inputWinningNumber()
    val bonusNum = inputBonusNumber()

    var winningCounts = mutableListOf<Int>()
    allLotto.forEach {
        winningCounts = Lotto(it.toList()).calculateLottoWin(lottoCount, allLotto, bonusNum)
    }

    printWinningScore(winningCounts)
    printWinningRate(winningCounts, money)
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

fun printLottoConut(money: Int): Int {
    var lottoCount = money / 1000
    println("\n${lottoCount}${Message.COUNT.message}")
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

fun printWinningScore(winningCounts: MutableList<Int>) {
    println(ScoreMessage.SCORE_TITLE.message)
    println(ScoreMessage.SCORE_LINE.message)
    println("${ScoreMessage.SCORE_THREE.message}${winningCounts[3]}개")
    println("${ScoreMessage.SCORE_FOUR.message}${winningCounts[4]}개")
    println("${ScoreMessage.SCORE_FIVE.message}${winningCounts[5]}개")
    println("${ScoreMessage.SCORE_FIVE_BONUS.message}${winningCounts[7]}개")
    println("${ScoreMessage.SCORE_SIX.message}${winningCounts[6]}개")
}

fun printWinningRate(winningCounts: MutableList<Int>, money: Int) {
    var totalPrice = 5000 * winningCounts[3] + 50000 * winningCounts[4] + 1500000 * winningCounts[5]
    +2000000000 * winningCounts[6] + 30000000 * winningCounts[7]
    var percent = totalPrice / money.toFloat() * 100
    println("총 수익률은 " + "%.1f".format(percent) + "%입니다.")
}