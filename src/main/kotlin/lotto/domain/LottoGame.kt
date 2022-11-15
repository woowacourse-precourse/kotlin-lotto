package lotto.domain

import lotto.data.Lotto
import lotto.data.WinningLotto
import lotto.data.WinningTable
import lotto.ui.Console

class LottoGame {

    fun play() {
        try {
            val money = Console.requestPurchaseAmount()
            val lotteries = makeLotteries(money)
            val winningLotto = getWinningLotto()

            showWinningResults(money, lotteries, winningLotto)
        } catch (e: Exception) {
            println(e.message)
        }
    }

    private fun makeLotteries(money: Int): List<Lotto> {
        return LottoShop.buy(money).also {
            Console.print(it)
        }
    }

    private fun getWinningLotto(): WinningLotto {
        return WinningLotto(
            lotto = Lotto(Console.requestWinningNumbers()),
            bonus = Console.requestBonusNumber(),
        )
    }

    private fun showWinningResults(
        money: Int,
        lotteries: List<Lotto>,
        winning: WinningLotto
    ) {
        Console.print(
            WinningTable(money, lotteries, winning)
        )
    }
}