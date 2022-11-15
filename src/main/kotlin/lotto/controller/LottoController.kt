package lotto.controller

import lotto.model.LottoNumber
import lotto.model.Price
import lotto.view.View

class LottoController {

    val view = View()
    private val myLotto = LottoNumber()
    private var winningNum = ArrayList<Int>()
    private val resultCentence = Price.RESULT.reward

    var sameThree = 0
    var sameFour = 0
    var sameFive = 0
    var sameFiveWithBonus = 0
    var sameSix = 0
    var count = 0

    val money = view.inputPurchasemoney()
    var myLottoGroup = myLotto.getLottoNumber(money)

    fun run() {

        winningNum = view.inputWinningNum() as ArrayList<Int>

        val bonus = view.inputBonusNum(winningNum)

        println(resultCentence)

        arrangeResult(bonus)

        view.outputSameLotto(sameThree , sameFour , sameFive , sameFiveWithBonus ,sameSix)
        
        println("총 수익률은 "+ countYield() + "%입니다.")
    }

    fun arrangeResult( bonusNum: Int) {

        for (i in 0 until myLottoGroup.size) {
            count = Lotto(myLottoGroup[i]).countSameLotto(winningNum, myLottoGroup[i])

            when (count) {
                3 -> {
                    sameThree++

                }
                4 -> {
                    sameFour++

                }
                5 -> {
                    if (Lotto(myLottoGroup[i]).countSameWithBonus(myLottoGroup[i], bonusNum)) {
                        sameFiveWithBonus++
                    }
                    if (!Lotto(myLottoGroup[i]).countSameWithBonus(myLottoGroup[i], bonusNum)) {
                        sameFive++
                    }
                }
                6 -> {
                    sameSix++
                }
            }

        }
    }

    fun countEarn(): Int {
        return (sameThree * 5000) + (sameFour * 50000) + (sameFive *1500000 ) + (sameFiveWithBonus * 30000000) + (sameSix * 2000000000)
    }

    fun countYield() : String {
       return "%.1f".format(countEarn().toDouble() / money.toDouble() * 100)
    }

}