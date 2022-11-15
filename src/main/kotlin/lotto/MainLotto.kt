package lotto

import use_case.BuyLotto
import use_case.DisplayLottoResult
import use_case.GetCorrectLotto

class MainLotto {

    companion object {
        fun startLottoGame() {
            val buyLotto = BuyLotto()
            val getCorrectLotto = GetCorrectLotto()
            DisplayLottoResult(buyLotto, getCorrectLotto)
        }
    }
}