package lotto

private const val INTRO_MSG = "구입금액을 입력해 주세요."
private const val ASK_WINNING_NUM="당첨 번호를 입력해 주세요."

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

}