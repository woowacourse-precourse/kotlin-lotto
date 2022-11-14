package lotto.domain

import lotto.data.WinningLotto
import lotto.data.WinningTable
import lotto.ui.Console

class LottoGame {

    fun play() {
        val money = Console.requestPurchaseAmount()
        val lotteries = LottoShop.buy(money)

        Console.print(lotteries)

        val winningLotto = WinningLotto(
            numbers = Console.requestWinningNumbers(),
            bonusNumber = Console.requestBonusNumber(),
        )

        Console.print(
            WinningTable(money, lotteries, winningLotto)
        )
    }
}