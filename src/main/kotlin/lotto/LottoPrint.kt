package lotto

import camp.nextstep.edu.missionutils.Console

class LottoPrint {
    private val logic = LottoLogic()

    private var count = 0
    fun lottoPurchaseAmount(){
        println("구매금액을 입력해 주세요.")
        val userPurchaseAmount = Console.readLine()
        var purchaseAmount = 0
        try {
            purchaseAmount = userPurchaseAmount.toInt()
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 범위 내 숫자를 입력하셔야 합니다.")
        }
        count = logic.lottoPurchaseAmount(purchaseAmount)
        lottoCount(count)
        lottoLists(logic.lottoCreateLists(count))
        lottoAnswer()
    }

    private fun lottoCount(count : Int) {
        println("\n${count}개를 구매했습니다.")
    }

    private fun lottoLists(listLotto : List<List<Int>>){
        for(i in listLotto.indices){
            println(listLotto[i])
        }
    }

    private fun lottoAnswer(){
        println("당첨 번호를 입력해 주세요.")
        val inputAnswer = Console.readLine().split(",")
        val answerNumbers = mutableListOf<Int>()
        try {
            for(element in inputAnswer){
                answerNumbers.add(element.toInt())
            }
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.")
        }
        Lotto(answerNumbers).lottoAnswer(answerNumbers)
    }
}