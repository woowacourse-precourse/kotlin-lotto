package lotto.ui

import lotto.Lotto
import lotto.data.Ranks
import lotto.domain.Calculator
import java.text.DecimalFormat

class PrintUi {
    fun pleaseInput(message:String){
        println("$message 입력해 주세요.")
    }

    fun printPurchaseNum(count:Int){
        println("${count}개를 구매했습니다.")
    }

    fun printLottos(lottos:List<Lotto>){
        for(index in lottos.indices){
            println(lottos[index].getNumbers())
        }
        println("")
    }

    fun printWinningStats(rankingCounts:HashMap<Int,Int>){
        println("\n당첨 통계\n---")
        for(rank in 5 downTo 1){
            when(rank){
                Ranks.FIRST.rank -> print("6개 일치 ")
                Ranks.SECOND.rank -> print("5개 일치, 보너스 볼 일치 ")
                Ranks.THIRD.rank -> print("5개 일치 ")
                Ranks.FOURTH.rank -> print("4개 일치 ")
                Ranks.FIFTH.rank -> print("3개 일치 ")
            }
            print("("+DecimalFormat("#,###").format(Calculator().prizeMoney(rank))+"원) - ")
            println("${rankingCounts[rank]}개")
        }
    }

    fun printYield( yield : Double){
        val decimal = DecimalFormat("#,##0.0")
        println("총 수익률은 "+ decimal.format(`yield`)+"%입니다.")
    }


}