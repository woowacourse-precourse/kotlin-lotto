package lotto.domain

import util.Printers

class LottoMachine(
    private val lotteries: List<Lotto>
) {

    // 구매한 로또 리스트 출력
    fun checkList() {
        Printers.lottoList(lotteries)
    }
}