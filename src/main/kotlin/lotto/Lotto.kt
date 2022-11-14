package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class __Lotto__(val repeats: Int) {
    var idx: MutableList<MutableList<Int>> = mutableListOf()

    init {
        repeat(repeats) {
            idx += setLottoNum().toMutableList()
            Lotto(idx.last().toList())
        }
    }

    private fun setLottoNum(): List<Int> {
        var lottoNum = mutableSetOf<Int>()
        while (lottoNum.size < 6) lottoNum += (1..45).random() //lottoNum += Randoms.pickNumberInRange(1, 45)
        return lottoNum.toList().sorted()
    }

    public fun printBuyLotto() {
        println("${idx.size}개를 구매했습니다.")
        idx.forEach { Lotto(it).printLotto() }
    }
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] : 길이가 6이 아닙니다" }
        require(numbers.distinct().size == numbers.size) { "[ERROR] : 중복된 숫자가 있습니다" }
        require(numbers.all { it in 1..45 }) { "[ERROR] : 1~45 사이의 숫자가 아닙니다" }
    }

    fun printLotto() = println(numbers)
}

class Service() {

    init {
        __Lotto__(buyLotto()).printBuyLotto()
    }
    public fun buyLotto(): Int {
        println("구입금액을 입력해 주세요.")
        // val lotto = Console.readLine("구입금액을 입력해 주세요.")
        val pay = readLine()?.toIntOrNull() ?: 0
        require(pay >= 1000) { "[ERROR] : 1000원 이상의 금액을 입력해주세요" }
        require(pay != 0) { "[ERROR] : 0보다 큰 숫자를 입력해주세요" }
        require(pay % 1000 == 0) { "[ERROR] : 1000원 단위로 입력해주세요" }
        println("")
        return pay / 1000
    }
}
