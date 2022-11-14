package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoMachine
import lotto.domain.User
import util.Printers

fun main() {
    try {
        val user = User()
        val money = user.inputMoney()
        val lottoGenerator = LottoGenerator(money)
        val lottoMachine = LottoMachine(lottoGenerator.getLottoList())

        lottoMachine.checkList()
        lottoMachine.setWinningAndBonusNumber()
        val list = lottoMachine.compareNumber()
        val rate = lottoMachine.yieldLottoResult(money)

        Printers.lottoResult(list, rate)
    } catch (e: Exception) {
        println(e.message)
    }
}
