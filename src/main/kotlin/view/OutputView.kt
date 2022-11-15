package view


class OutputView {

    private val MESSAGE_HOW_MUCH_BUY_TICKET = "구입금액을 입력해 주세요."
    private val MESSAGE_BUY_TICKET = "개를 구매했습니다."
    private val MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private val MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    private val MESSAGE_WINNING_STATISTICS = "당첨 통계"

    fun outputHowMuchBuy(){
        println(MESSAGE_HOW_MUCH_BUY_TICKET)
    }

    fun outputWinningNumber(){
        println(MESSAGE_WINNING_NUMBER)
    }

    fun outputBonusNumber(){
        println(MESSAGE_BONUS_NUMBER)
    }

    // 구매한 티켓 개수 출력
    fun outputAvailableTickets(availableTickets: Long){
        println("$availableTickets$MESSAGE_BUY_TICKET")
    }

    fun newLine(){
        println()
    }

    fun outputListOfLotto(listOfLotto: Set<List<Int>>){
        println(listOfLotto.joinToString("\n"))
    }

    fun outputWinningStatistics(){
        println(MESSAGE_WINNING_STATISTICS)
        println("---")
    }

    // 당첨 통계 출력
    fun outputWinningStatisticsResult(lottoMap:Map<String, Int>){
        for (i in lottoMap){
            println("${i.key} - ${i.value}개")
        }
    }

    // 수익률 출력
    fun outputTotalYield(userPayMoney:Long ,income: Int){
        val totalYield = String.format("%.1f", (income/(userPayMoney*1000)).toDouble()*100)
        println("총 수익률은 ${totalYield}%입니다.")
    }

}