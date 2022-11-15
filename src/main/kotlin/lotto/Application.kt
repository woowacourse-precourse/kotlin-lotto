package lotto

import enterprise.LottoEnterprise
import market.LottoMarket
import winlotto.WinLottoFactory

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
