package view

import domain.LottoNumberRepository

class OutputView {

    private val MESSAGE_BUY_TICKET = "개를 구매했습니다."

    // 구매한 티켓 개수 출력
    fun outputAvailableTickets(availableTickets: Long){
        println("\n$availableTickets$MESSAGE_BUY_TICKET")
    }

    fun outputListOfLotto(availableTickets: Long){
        // 로또 생성
        val lottoNumberRepository = LottoNumberRepository()
        val listOfLotto = lottoNumberRepository.lottoNumberRepository(availableTickets)
        println(listOfLotto.joinToString("\n"))
    }

}