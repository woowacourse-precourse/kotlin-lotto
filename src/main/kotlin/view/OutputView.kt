package view

class OutputView {

    private val MESSAGE_BUY_TICKET = "개를 구매했습니다."

    // 구매한 티켓 개수 출력
    fun outputAvailableTickets(availableTickets: Long){
        println("\n$availableTickets$MESSAGE_BUY_TICKET")
    }

}