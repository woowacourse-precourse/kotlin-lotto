package lotto

private const val INTRO_MSG = "구입금액을 입력해 주세요."
private const val ASK_WINNING_NUM="당첨 번호를 입력해 주세요."
private const val ASK_BONUS_NUM="보너스 번호를 입력해 주세요."
private const val WINNING_STATS="당첨 통계"

class LottoPrinter {

    fun printIntroMsg() = println(INTRO_MSG)

    fun printTicketsCount(amount:Int){
        val count=amount/1000
        println()
        println("${count}개를 구매했습니다.")
    }

    fun printMyTickets(user:User){
        for(count in 0 until user.myLottoTickets.size){
            println(user.myLottoTickets[count].getNumbers())
        }
        println()
    }

    fun printAskingWinningNumber() = println(ASK_WINNING_NUM)
    fun printAskingBonusNumber() = println("\n"+ ASK_BONUS_NUM)
    fun printResultStats(myResult:List<Int>){
        println()
        println(WINNING_STATS)
        println("---")
        println("3개 일치 (5,000원) - ${myResult[4]}개")
        println("4개 일치 (50,000원) - ${myResult[3]}개")
        println("5개 일치 (1,500,000원) - ${myResult[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${myResult[1]}개")
        println("6개 일치 (2,000,000,000원) - ${myResult[0]}개")
    }
    fun printRatesofResult(rates:Double){
        println("총 수익률은 "+"%.1f".format(rates)+"%입니다.")
    }

}