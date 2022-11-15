package lotto

import enterprise.LottoEnterprise
import market.LottoMarket
import player.LottoPlayer
import view.EnterpriseUI
import view.MarketUI
import winlotto.WinLottoFactory

fun main() {
    val player = getPlayer()
    player.buyLotties()
    player.matchLotties()
}

private fun getPlayer(): LottoPlayer {
    val lottoEnterprise = LottoEnterprise(
        WinLottoFactory(),
        EnterpriseUI()
    )
    val lottoMarket = LottoMarket(
        LottoFactory(),
        marketUI = MarketUI()
    )
    return LottoPlayer(
        lottoEnterprise,
        lottoMarket
    )
}
