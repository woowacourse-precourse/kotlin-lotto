package lotto.controller

import lotto.model.LottoNumber
import lotto.model.Number
import lotto.model.Price
import lotto.view.View

class LottoController {

    val view = View()
    private val myLotto = LottoNumber()
    private var winningNum = ArrayList<Int>()

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

        println(Price.RESULT.reward)

        arrangeResult(bonus)

        view.outputSameLotto(sameThree, sameFour, sameFive, sameFiveWithBonus, sameSix)

        view.outputYield(countYield())
    }

    fun arrangeResult(bonusNum: Int) {

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
        return (sameThree * Number.Fifth.value) +
                (sameFour * Number.Fourth.value) +
                (sameFive * Number.Third.value) +
                (sameFiveWithBonus * Number.Second.value) +
                (sameSix * Number.First.value)
    }

    fun countYield(): String {
        return "%.1f".format(countEarn().toDouble() / money.toDouble() * 100)
    }

}