package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame {
    private var money = Money(0)
    private val lottoList = mutableListOf<Lotto>()
    private var winningNumber = Lotto(listOf(0,0,0,0,0,0))

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
        winningNumber = Lotto(result)
    }

}