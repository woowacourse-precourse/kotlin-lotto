package lotto.domain

import lotto.data.Lotto
import lotto.data.WinningLotto
import lotto.data.WinningTable
import lotto.ui.Console

class LottoGame {

    fun play() {
        val money = Console.requestPurchaseAmount()
        val lotteries = LottoShop.buy(money)

        Console.print(lotteries)

        val winningLotto = WinningLotto(
            lotto = Lotto(Console.requestWinningNumbers()),
            bonus = Console.requestBonusNumber(),
        )

        Console.print(
            WinningTable(money, lotteries, winningLotto)
        )
    }
}