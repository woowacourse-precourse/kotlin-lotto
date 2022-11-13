package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LOTTO_END_NUMBER
import lotto.utils.LOTTO_SIZE
import lotto.utils.LOTTO_START_NUMBER
import lotto.presentation.LottoConsole.inputPurchaseAmount
import lotto.presentation.LottoConsole.printPurchaseMessage
import lotto.presentation.LottoConsole.printPurchaseResult

class LottoStore {

    fun purchase(): List<Lotto> {
        printPurchaseMessage()
        val amount: Money = inputPurchaseAmount()
        val lottos = arrayListOf<Lotto>()

        for (i in 0 until amount.convertLottoCount()) {
            lottos.add(publish())
        }

        printPurchaseResult(lottos)
        return lottos
    }

    private fun publish(): Lotto {
        val uniqueNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
            .map { number -> LottoNumber(number) }

        return Lotto(uniqueNumbers)
    }
}