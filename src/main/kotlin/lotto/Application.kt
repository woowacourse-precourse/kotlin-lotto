package lotto

import lotto.domain.domain
import lotto.ui.ui

fun main() {
    var ui = ui()
    var domain = domain()

    var money = ui.moneyInput()
    var lottoNumber = domain.lottoNumberCalculate(money)

    var lottoPublishment = domain.lottoPublish(lottoNumber)

}
