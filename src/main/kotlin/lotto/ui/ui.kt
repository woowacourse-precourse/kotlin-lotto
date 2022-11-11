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

    fun bonusNumber() : Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun printLottoResult(three : Int, four : Int, five : Int, fivebonus : Int, six : Int){
        println("당첨 통계\n---")
        print(lottoWinningDetails.THREE.message)
        println(" - "+three.toString()+"개")
        print(lottoWinningDetails.FOUR.message)
        println(" - "+four.toString()+"개")
        print(lottoWinningDetails.FIVE.message)
        println(" - "+five.toString()+"개")
        print(lottoWinningDetails.FIVEBONUS.message)
        println(" - "+fivebonus.toString()+"개")
        print(lottoWinningDetails.SIX.message)
        println(" - "+six.toString()+"개")
    }
}

enum class lottoWinningDetails(val message : String) {
    THREE("3개 일치 (5,000원)"),
    FOUR("4개 일치 (50,000원)"),
    FIVE("5개 일치 (1,500,000원)"),
    FIVEBONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX("6개 일치 (2,000,000,000원)")
}