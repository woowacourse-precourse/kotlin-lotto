package lotto

import camp.nextstep.edu.missionutils.Randoms

class Ticket {
    fun makeLottoTicket(): MutableList<Int> {
        val lottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoTicket.sort()
        return lottoTicket
    }
}