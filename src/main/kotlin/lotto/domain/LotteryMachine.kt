package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LotteryMachine {

    fun operate(lottoCount: Long): List<Lotto> {
        val lottoTicket = mutableListOf<Lotto>()
        while (lottoTicket.size < lottoCount) {
            lottoTicket.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()))
        }

        return lottoTicket
    }
}
