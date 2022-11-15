package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class Rank(var match: Int, var reward: Int) {

    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000)

}

fun main() {

}

class LottoNumber {

    private var money = 0
    private var number = 0
    private var lottoNumberList = mutableListOf<List<Int>>()

    private fun winnerNumber(): List<Int> {
        println("\n당첨 번호를 입력해 주세요.")
        val winNumber = Console.readLine().split(",").map { it.toInt() }
        Lotto(winNumber)

        println("당첨 번호 : $winNumber")
        return winNumber
    }

    private fun bonusNumber(lottoNumber: List<Int>): Int {

        println("\n보너스 번호를 입력해 주세요.")

        val bonusNumber = Console.readLine().toInt()
        require(!lottoNumber.contains(bonusNumber)) { "[ERROR] 같은 수가 포함되어 있다." }

        println(bonusNumber)
        return bonusNumber
    }

    private fun lottoRandomNumber(number: Int): MutableList<List<Int>> {

        val lottoNumberList = mutableListOf<List<Int>>()

        for (i in 1..number) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(lottoNumber)    // 에러 체크
            lottoNumberList.add(lottoNumber)
        }

        // println(lottoNumberList)
        return lottoNumberList
    }


    private fun lottoResult(winnerNumList: List<Int>, bonusNumber: Int): Array<Int> {

        val win = Array(8) { 0 }

        lottoNumberList.forEach { lottoNumber ->

            val size = lottoNumber.filter { it in winnerNumList }.size

            if (size >= 3) {
                win[size] += 1
            }
            if (size == 5 && lottoNumber.contains(bonusNumber)) {
                win[5] -= 1
                win[7] += 1
            }
        }
        // println(win)
        return win
    }

    private fun printResult(resultArray: Array<Int>) {

        println("3개 일치 (5,000원) - ${resultArray[3]}개")
        println("4개 일치 (50,000원) - ${resultArray[4]}개")
        println("5개 일치 (1,500,000원) - ${resultArray[5]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${resultArray[7]}개")
        println("6개 일치 (2,000,000,000원) - ${resultArray[6]}개")

    }

    private fun rateOfReturn(money: Int, resultArray: Array<Int>): Double {

        var result = 0
        for (i in 3..7) {
            when (i) {
                3 -> {
                    result += Rank.FIFTH.reward * resultArray[i]
                }

                4 -> {
                    result += Rank.FOURTH.reward * resultArray[i]
                }

                5 -> {
                    result += Rank.THIRD.reward * resultArray[i]
                }

                6 -> {
                    result += Rank.FIRST.reward * resultArray[i]
                }

                7 -> {
                    result += Rank.SECOND.reward * resultArray[i]
                }
            }
        }

        // println(result.toFloat() / money * 100)
        return result.toDouble() / money * 100
    }
}