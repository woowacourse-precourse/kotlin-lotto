package lotto.ui

import camp.nextstep.edu.missionutils.Console

class ui {
     fun moneyInput() : Int {
        println("구입금액을 입력해 주세요.")
        var money = Console.readLine().toInt()
        return money
    }

    fun correctNumber() : List<Int>{
        println("당첨 번호를 입력해 주세요.")

        var correctNumberNew = mutableListOf<Int>()
        var correctNumberOld = Console.readLine().split(",")

        for (i in 0..correctNumberOld.size-1){
            correctNumberNew.add(correctNumberOld[i].toInt())
        }
        correctNumberNew.toList()

        return correctNumberNew
    }

}
