package lotto

import lotto.domain.domain
import lotto.ui.ui
import java.lang.IllegalArgumentException

fun main() {
    var ui = ui()
    var domain = domain()
    var money = ui.moneyInput()

    if (money != 1){
        var lottoNumber = domain.lottoNumberCalculate(money)
        var lottoPublishment = domain.lottoPublish(lottoNumber)

        var lotto = Lotto(ui.correctNumber())
        var bonusNumber = ui.bonusNumber()

        var lottoCoincidence = domain.lottoCoincidence(lottoPublishment, lotto, bonusNumber)
        lotto.LottoResult(lottoCoincidence, money)
    }
}
