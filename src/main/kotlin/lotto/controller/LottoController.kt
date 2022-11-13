package lotto.controller

import lotto.model.LottoNumber
import lotto.view.Input

class LottoController{

    val input = Input()
    private val myLotto = LottoNumber()
    private var winningNum = ArrayList<String>()


    fun run(){

        val money = input.inputPurchasemoney()

        var myLottoGroup = myLotto.noticeLottoNumber(money)

        winningNum = input.inputWinningNum() as ArrayList<String>

        input.inputBonusNum(winningNum)
    }




}