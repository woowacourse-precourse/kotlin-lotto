package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import message.Message
import message.ScoreMessage

fun main() {
    val money = inputMoney()
    val lottoCount = printLottoConut(money)
    val allLotto = publishLotto(lottoCount)
    val winningNum = inputWinningNumber()
    val bonusNum = inputBonusNumber()
    val winningList = calculateLottoWin(lottoCount, allLotto, winningNum, bonusNum)
    printWinningScore(winningList)
    printWinningRate(winningList, money)
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
    var winningNum = Console.readLine().split(",")
    winningNum.forEach {
        checkNumberScope(it.toInt())
    }
    for (i in 0..4) {
        for (j in i + 1..5) {
            if (winningNum[i] == winningNum[j]) {
                throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
            }
        }
    }
    return winningNum
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

fun calculateLottoWin(
    lottoCount: Int,
    allLotto: Array<IntArray>,
    winningNum: List<String>,
    bonusNum: Int,
): MutableList<Int> {
    var bonusCount = 0
    var winningList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0)

    for (i in 0 until lottoCount) {
        val lottos = allLotto[i].toList()
        var answerCount = 0
        for (j in 0..5) {
            val lottoNum = lottos[j]
            for (k in 0..5) {
                if (winningNum[k].toInt() == lottoNum) {
                    answerCount++
                }
                if (bonusNum == lottoNum) {
                    bonusCount = 1
                }
            }
        }
        if (answerCount != 0) {
            winningList[answerCount] = winningList[answerCount] + 1
        }
        if (answerCount == 5 && bonusCount == 1) {
            winningList[7] = winningList[7] + 1
        }
    }

    return winningList
}

fun printWinningScore(winningList: MutableList<Int>) {
    println(ScoreMessage.SCORE_TITLE.message)
    println(ScoreMessage.SCORE_LINE.message)
    println("${ScoreMessage.SCORE_THREE.message}${winningList[3]}개")
    println("${ScoreMessage.SCORE_FOUR.message}${winningList[4]}개")
    println("${ScoreMessage.SCORE_FIVE.message}${winningList[5]}개")
    println("${ScoreMessage.SCORE_FIVE_BONUS.message}${winningList[7]}개")
    println("${ScoreMessage.SCORE_SIX.message}${winningList[6]}개")
}

fun printWinningRate(winningList: MutableList<Int>, money: Int) {
    var totalPrice = 5000 * winningList[3] + 50000 * winningList[4] + 1500000 * winningList[5]
    +2000000000 * winningList[6] + 30000000 * winningList[7]
    var percent = totalPrice / money.toFloat() * 100
    println("총 수익률은 " + "%.1f".format(percent) + "%입니다.")
}