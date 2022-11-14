package lotto

import kotlin.math.round

class Consumer(private val money: Int) {
    val myLotto = mutableListOf<List<Int>>()

    init {
        require(money % 1000 == 0) { println("[ERROR] 1000원 단위가 아닙니다.") }
        require(money >= 1000) { println("[ERROR] 돈이 부족합니다") }
    }

    fun buyLotto(){
        for(lottoCount in 0 until money/1000){
            val lottoList = LottoShop().createLotto()
            myLotto.add(lottoList)
        }
    }

    fun compareLotto(winningNumbers : Lotto, bonusNumber : Int) : List<Int>{
        return LottoCalculator(myLotto, winningNumbers,bonusNumber).calculateLotto()
    }

    fun calculateYield(winnings : List<Int>) : String{
        var sum = 0
        sum=Winnings.FIRST_PLACE.sum(winnings[0])+
                Winnings.SECOND_PLACE.sum(winnings[1])+
                Winnings.THIRD_PLACE.sum(winnings[2])+
                Winnings.FOURTH_PLACE.sum(winnings[3])+
                Winnings.FIFTH_PLACE.sum(winnings[4])
        return String.format("%.1f",round(((sum*100).toDouble()/money)* ROUND_POSITION)/ ROUND_POSITION)
    }
}