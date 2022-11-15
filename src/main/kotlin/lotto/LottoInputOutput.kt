package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.math.round

class LottoInputOutput {
    private var lotto : Lotto? = null
    private val logic = LottoLogic()
    private var count = 0
    fun lottoPurchaseAmount(){
        println("구매금액을 입력해 주세요.")
        val userPurchaseAmount = Console.readLine()
        var purchaseAmount = 0
        try {
            purchaseAmount = userPurchaseAmount.toInt()
        } catch (e:Exception) {
            //println("[ERROR] 범위 내 숫자를 입력하셔야 합니다.")
            throw IllegalArgumentException("[ERROR] 범위 내 숫자를 입력하셔야 합니다.")
        }
        count = logic.lottoPurchaseAmount(purchaseAmount)
        lottoCount(count)
    }

    private fun lottoCount(count : Int) {
        println("\n${count}개를 구매했습니다.")
        lottoLists(logic.lottoCreateLists(count))
        finalLotto()
    }

    private fun lottoLists(listLotto : List<List<Int>>) {
        for(i in listLotto.indices){
            println(listLotto[i])
        }
    }

    private fun lottoAnswer() : List<Int>{
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
        return answerNumbers
    }

    private fun lottoBonus() :Int{
        println("보너스 번호를 입력해 주세요.")
        val inputBonus = Console.readLine()
        var bonusNumber = 0
        try {
            bonusNumber = inputBonus.toInt()
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.")
        }
        return bonusNumber
    }

    private fun finalLotto(){
        lotto = Lotto(lottoAnswer(), lottoBonus())
        printResult()
    }

    fun printResult(){
        println("\n당첨 통계\n---")
        val price = lotto?.getSumPrice(logic.getUserLottoList())
        LottoStats.values().forEach{
            println("${it.message} - ${it.Cnt}개")
        }
        val rateOfReturn = price?.let { logic.getRate(it) }
        if (rateOfReturn != null) {
            println("총 수익률은 ${round(rateOfReturn*10) /10}%입니다.")
        }
    }
}