package lotto

import camp.nextstep.edu.missionutils.Randoms

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
        require(numbers.size == 6) { "[Error] : 길이가 6이 아닙니다" }
        require(numbers.distinct().size == numbers.size) { "[Error] : 중복된 숫자가 있습니다" }
        require(numbers.all { it in 1..45 }) { "[Error] : 1~45 사이의 숫자가 아닙니다" }
    }

    fun printLotto() = println(numbers)
}
