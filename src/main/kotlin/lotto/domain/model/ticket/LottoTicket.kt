package lotto.domain.model.ticket

data class LottoTicket (
    var ticketMoney: Int,
    var ticketCount: Int,
    var lottos: List<Lotto>
) {
    companion object {
        fun emptyLottoTicket() = LottoTicket(ticketMoney = -1, ticketCount = -1, listOf())
    }
}