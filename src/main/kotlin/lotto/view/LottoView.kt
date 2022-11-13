package lotto.view

import lotto.logic.Rank

class LottoView {

    fun getPrice(): Long{
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toLong()
    }
}