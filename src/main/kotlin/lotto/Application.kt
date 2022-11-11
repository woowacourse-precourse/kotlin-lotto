package lotto

import lotto.domain.LottoGenerator
import lotto.exception.InputExceptionHandler
import lotto.view.Input
import lotto.view.Output

fun main() {
    val input = Input()
    val money = input.inputMoney()
    val inputExceptionHandler = InputExceptionHandler()
    inputExceptionHandler.moneyException(money)
    val count = money/1000
    val lottoGenerator = LottoGenerator()
    val lottos = lottoGenerator.generate(count)
    val output = Output()
    output.printLottoCount(count)
    output.printLotto(lottos)
}
