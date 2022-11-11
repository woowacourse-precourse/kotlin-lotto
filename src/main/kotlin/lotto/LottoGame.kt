package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val LOTTO_PRICE = 1000

class LottoGame() {

    var money = ""
    val lottos = mutableListOf<List<Int>>()
    val checkprize:MutableList<Int> = mutableListOf(0,0,0,0,0)

    fun gamestart() {
        getusermoney()
        makelottonumber()
        val userlotto=getuserlotto()


    }


    private fun getusermoney() {
        money = Console.readLine()
    }

    private fun makelottonumber() {
        LottoErrorCheck.checkallmoneyerror(money)
        val count = money.toInt() / LOTTO_PRICE
        printcount(count)
        createlottos(count)
        printlottolist()
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

    private fun getuserlotto():List<Int>{
        val userinput = Console.readLine()
        val userinputparsing= userinput.split(",")
        val userinputnumber= mutableListOf<Int>()

        for(element in userinputparsing){
            LottoErrorCheck.checkinputisnumber(element)
            userinputnumber.add(element.toInt())
        }

        return userinputnumber.toList()

    }

    private fun checklotto(){

    }

}