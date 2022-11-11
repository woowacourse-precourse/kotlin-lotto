package lotto.domain.model.ticket

data class LottoTicket (
    var ticketMoney: Int,
    var ticketCount: Int,
    var lottos: List<Lotto>
) {
    companion object {
        fun emptyLottoTicket() = LottoTicket(-1, -1, listOf())
    }
}