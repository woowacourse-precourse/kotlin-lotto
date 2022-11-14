package lotto.ui

import lotto.Lotto

class PrintUi {
    fun pleaseInput(message:String){
        println("$message 입력해 주세요.")
    }

    fun printPurchaseNum(count:Int){
        println("${count}개를 구매했습니다.")
    }

    fun printLottos(lottos:List<Lotto>){
        for(index in lottos.indices){
            println(lottos[index].getNumbers())
        }
    }
}