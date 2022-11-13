package lotto

fun main() {
    val player = getPlayer()
    player.buyLotties()
    player.matchLotties()
}

private fun getPlayer(): LottoPlayer {
    val lottoEnterprise = LottoEnterprise(
        WinLottoFactory()
    )
    val lottoMarket = LottoMarket(
        LottoFactory()
    )
    return LottoPlayer(
        lottoEnterprise,
        lottoMarket
    )
}
