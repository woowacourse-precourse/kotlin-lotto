package lotto

import lotto.domain.LottoGenerator
import lotto.view.Input
fun main() {
    val input = Input()
    val money = input.inputMoney()
    val inputExceptionHandler = InputExceptionHandler()
    inputExceptionHandler.moneyException(money)
    val count = money/1000
    val lottoGenerator = LottoGenerator()
    val lottos = lottoGenerator.generate(count)
}
