package lotto.view

import lotto.Lotto

enum class Print{
    PRINT_COUNT
}

fun getPrint(s:Print):String{
    when(s){
        Print.PRINT_COUNT -> return "개를 구매했습니다."
    }
}

class Output {

    fun printLottoCount(count:Int){
        println(count.toString() + getPrint(Print.PRINT_COUNT))
    }

    fun printLotto(lottos:List<Lotto>){
        for (lotto in lottos){
            println(lotto.getNumbers())
        }
    }
}