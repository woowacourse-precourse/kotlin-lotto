package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private var money = Money(0)
    private val lottoList = mutableListOf<Lotto>()
    private var winningNumber = listOf<Int>()
    private var bonusNumber = 0

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

    fun calculateResult(): MutableList<Int> {
        val prizeResult = mutableListOf<Int>(0,0,0,0,0,0)
        for (lotto in lottoList) {
            val containNumberCount = lotto.compareWithWinningNumber(winningNumber)
            val rank: Int = lotto.determineRank(containNumberCount, bonusNumber) as Int
            prizeResult[rank]++
        }
        return prizeResult
    }

    fun printResult() {
        val prizeResult = calculateResult()
        println("3개 일치 (5,000원) - ${prizeResult[5]}개")
        println("4개 일치 (50,000원) - ${prizeResult[4]}개")
        println("5개 일치 (1,500,000원) - ${prizeResult[3]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${prizeResult[2]}개")
        println("6개 일치 (2,000,000,000원) - ${prizeResult[1]}개")
    }



}