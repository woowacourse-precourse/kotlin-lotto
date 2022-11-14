package lotto.controller

import lotto.model.LottoNumber
import lotto.model.Price
import lotto.view.Input

class LottoController {

    val input = Input()
    private val myLotto = LottoNumber()
    private var winningNum = ArrayList<Int>()
    private val resultCentence = Price.RESULT.reward

    var sameThree = 0
    var sameFour = 0
    var sameFive = 0
    var sameFiveWithBonus = 0
    var sameSix = 0
    var count = 0

    val money = input.inputPurchasemoney()
    var myLottoGroup = myLotto.getLottoNumber(money)

    fun run() {

        winningNum = input.inputWinningNum() as ArrayList<Int>


        val bonus = input.inputBonusNum(winningNum)

        println(resultCentence)


        arrangeResult(bonus)


        println(Price.THREE.reward + sameThree + "개")
        println(Price.FOUR.reward + sameFour + "개")
        println(Price.FIVE.reward + sameFive + "개")
        println(Price.FIVE_WITH_BONUS.reward + sameFiveWithBonus + "개")
        println(Price.SIX.reward + sameSix + "개")

    }

    fun arrangeResult( bonusNum: Int) {

        for (i in 0 until myLottoGroup.size) {
            count = Lotto(myLottoGroup[i]).countSameLotto(winningNum, myLottoGroup[i])

            when (count) {
                3 -> {
                    sameThree++
                    println("3개적립")
                }
                4 -> {
                    sameFour++
                    println("4개적립")
                }
                5 -> {
                    if (Lotto(myLottoGroup[i]).countSameWithBonus(myLottoGroup[i], bonusNum)) {
                        sameFiveWithBonus++
                        println("5개 보너스 적립")
                    }
                    if (!Lotto(myLottoGroup[i]).countSameWithBonus(myLottoGroup[i], bonusNum)) {
                        sameFiveWithBonus++
                        println("5개 보너스 적립")
                    }
                }
                6 -> {
                    sameSix++
                    println("6개적립")
                }
            }

        }
    }

}