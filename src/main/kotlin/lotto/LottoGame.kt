package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val LOTTO_PRICE = 1000

class LottoGame() {

    var money = ""
    var lottos = mutableListOf<List<Int>>()

    fun gamestart() {
        getusermoney()
        makelottonumber()


    }


    private fun getusermoney() {
        money = Console.readLine()
    }

    private fun makelottonumber(): Int {
        LottoErrorCheck.checkallmoneyerror(money)
        val count = money.toInt() / LOTTO_PRICE
        printcount(count)
        createlottos(count)
        printlottolist()
        return count
    }

    private fun printcount(count: Int) {
        println("$count" + "개를 구입했습니다.")
    }

    private fun createlottos(count: Int) {
        for (number: Int in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(numbers)
        }
    }

    private fun printlottolist() {
        for (number: Int in 0 until lottos.size) {
            println(lottos[number])
        }
    }

}