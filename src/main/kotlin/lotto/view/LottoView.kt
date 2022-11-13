package lotto.view

import lotto.logic.Rank

class LottoView {

    fun getPrice(): Long{
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toLong()
    }

    fun printLotto(lottos: ArrayList<List<Int>>){
        println("\n${lottos.size}개를 구매했습니다.")
        for(i in lottos.indices)
            println(lottos[i])
    }
}