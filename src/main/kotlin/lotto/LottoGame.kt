package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {

    val LOTTOPRICE=1000
    var money=0
    var lottos = mutableListOf<Int>()

    fun gamestart(){
        getusermoney()
        makelottonumber()


    }


    private fun getusermoney(){
        money=Console.readLine().toInt()
    }

    private fun makelottonumber():Int{
        //넣기전 예외처리 먼저
        val count = money/LOTTOPRICE
        printcount(count)


        return count
    }

    private fun printcount(count:Int){
        println("$count"+"개를 구입했습니다.")
    }


}