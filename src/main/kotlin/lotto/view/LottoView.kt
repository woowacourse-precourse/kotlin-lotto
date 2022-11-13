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

    fun getWinningNumber(): List<Int>{
        println("\n당첨 번호를 입력해 주세요.")
        return readLine()!!.split(",").map { it.toInt() }
    }

    fun getBonusNumber(): Int{
        println("\n보너스 번호를 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun printRankResult(rankResult: MutableMap<Rank, Int>){
        println("\n당첨 통계\n" + "---")
        println("3개 일치 (5,000원) - ${rankResult[Rank.Fifth]}개\n" +
                "4개 일치 (50,000원) - ${rankResult[Rank.Fourth]}개\n" +
                "5개 일치 (1,500,000원) - ${rankResult[Rank.Third]}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankResult[Rank.Second]}개\n" +
                "6개 일치 (2,000,000,000원) - ${rankResult[Rank.First]}개")
    }
}