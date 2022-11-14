package lotto.ui

import lotto.Lotto
import lotto.data.Ranks
import lotto.domain.Calculator

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
    }

    fun printWinningStats(rankingCounts:HashMap<Int,Int>){
        println("당첨 통계\n---")
        for(rank in 5..1){
            when(rank){
                Ranks.FIRST.rank -> print("6개 일치 ")
                Ranks.SECOND.rank -> print("5개 일치, 보너스 볼 일치 ")
                Ranks.THIRD.rank -> print("5개 일치 ")
                Ranks.FOURTH.rank -> print("4개 일치 ")
                Ranks.FIFTH.rank -> print("3개 일치 ")
            }
            print("("+String.format("#,###.0")+"원) - ")
            println("${rankingCounts[rank]}개")
        }
    }

    fun printYield( _yield : Double){
        println("수익률:"+ String.format("#,###.0", _yield *100 )+"%")
    }


}