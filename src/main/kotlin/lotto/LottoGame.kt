package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToLong

class LottoGame {
    private var money = Money(0)
    private val lottoList = mutableListOf<Lotto>()
    private var winningNumber = listOf<Int>()
    private var bonusNumber = 0
    val prizeResult = mutableListOf<Int>(0,0,0,0,0,0)
    var totalEarnedMoney = 0.0

    fun receiveMoney(money: String) {
        if (!money.all { Character.isDigit(it) })
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        this.money = Money(money.toInt())
    }

    fun printLottoCount(): Int {
        return money.countLotto()
    }

    private fun createLotto() {
        for (i in 0 until money.countLotto()) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoList.add(Lotto(numbers.sorted()))
        }
    }

    fun printLotto() {
        createLotto()
        for (i in 0 until lottoList.size) {
            println(lottoList[i].printLottoNumber())
        }
    }

    fun receiveWinningNumber(number: String) {
        val num = number.split(",")
        val result = mutableListOf<Int>()
        for (element in num) {
            result.add(element.toInt())
        }
        // TODO:  num의 길이, 숫자인지여부, 중복 검사
        winningNumber = result.sorted()
    }

    fun receiveBonusNumber(number: String) {
        // TODO: 입력값 유효한 숫자인지 검사
        bonusNumber = number.toInt()
    }

    fun calculateResult(){
        for (lotto in lottoList) {
            val containNumberCount = lotto.compareWithWinningNumber(winningNumber)
            val rank = lotto.determineRank(containNumberCount, bonusNumber)
            when (rank) {
                Rank.First -> {
                    prizeResult[1]++
                    totalEarnedMoney += Rank.First.prizeMoney
                }
                Rank.Second -> {
                    prizeResult[2]++
                    totalEarnedMoney += Rank.Second.prizeMoney
                }
                Rank.Third -> {
                    prizeResult[3]++
                    totalEarnedMoney += Rank.Third.prizeMoney
                }
                Rank.Fourth -> {
                    prizeResult[4]++
                    totalEarnedMoney += Rank.Fourth.prizeMoney
                }
                Rank.Fifth -> {
                    prizeResult[5]++
                    totalEarnedMoney += Rank.Fifth.prizeMoney
                }
            }
        }
    }

    fun printResult() {
        calculateResult()
        println("3개 일치 (5,000원) - ${prizeResult[5]}개")
        println("4개 일치 (50,000원) - ${prizeResult[4]}개")
        println("5개 일치 (1,500,000원) - ${prizeResult[3]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${prizeResult[2]}개")
        println("6개 일치 (2,000,000,000원) - ${prizeResult[1]}개")
    }

    fun calculateProfitPercentage(): Double {
        val profit = (totalEarnedMoney / money.getMoney().toDouble())*1000
        return (profit.roundToLong().toDouble()/10)
    }

}