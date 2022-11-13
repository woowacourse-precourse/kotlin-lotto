package lotto.view

import lotto.Lotto
import java.lang.StringBuilder

object OutputView {

    fun printLottoCount(lottoCount: Long) {
        println("\n${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumber(lottoTicket: List<Lotto>) {
        val builder = StringBuilder()

        lottoTicket.forEach { lotto: Lotto ->
            builder.append(lotto.getNumbers()).append('\n')
        }

        println(builder)
        builder.setLength(0)
    }
}
