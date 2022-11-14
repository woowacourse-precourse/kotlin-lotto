package view

import domain.LottoNumberRepository

class OutputView {

    private val MESSAGE_HOW_MUCH_BUY_TICKET = "구입금액을 입력해 주세요."
    private val MESSAGE_BUY_TICKET = "개를 구매했습니다."
    private val MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private val MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

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

    fun outputListOfLotto(availableTickets: Long){
        // 로또 생성
        val lottoNumberRepository = LottoNumberRepository()
        val listOfLotto = lottoNumberRepository.lottoNumberRepository(availableTickets)
        println(listOfLotto.joinToString("\n"))
    }

}