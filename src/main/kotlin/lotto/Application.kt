package lotto

import lotto.domain.LottoCheck
import lotto.domain.LottoShop
import lotto.domain.LottoWin
import lotto.presentation.LottoBank
import lotto.presentation.LottoOrder

fun main() {
    val lottoOrder: LottoOrder = LottoOrder()
    val lottoShop: LottoShop = LottoShop()
    val lottoWin: LottoWin = LottoWin()
    val lottoCheck: LottoCheck = LottoCheck()
    val lottoBank: LottoBank = LottoBank()

    val userOrder = lottoOrder.orderUser()
    if (userOrder == 0) return
    val userLottoNumber = lottoShop.buyLotto(userOrder)
    lottoWin.winLotto()
    val lottoRank = lottoCheck.compareLotto(userLottoNumber)
    lottoBank.yieldLotto(lottoRank, userOrder)
}
