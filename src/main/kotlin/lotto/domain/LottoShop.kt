package lotto.domain

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.LottoShopChecker.checkBonusNumber
import lotto.domain.LottoShopChecker.checkPurchasingAmount
import lotto.ui.View

class LottoShop {
    private val view = View

    fun retryGetPurchasingAmount(lottoShop: LottoShop): Int {
        var lottoCount: Int
        do {
            view.showPurchasingAmount()
            lottoCount = lottoShop.getPurchasingAmount()
        } while (lottoCount == 0)
        return lottoCount
    }

    private fun getPurchasingAmount(): Int {
        val purchasingAmount = Console.readLine().trim()
        return try {
            checkPurchasingAmount(purchasingAmount)
            (purchasingAmount.toInt() / 1000).also { view.showCount(it) }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            0
        }
    }

    fun getLottoNumbers(lottoCount: Int): MutableList<Lotto> {
        val lottoNumbers: MutableList<Lotto> = mutableListOf()
        for (i in 0 until lottoCount) {
            lottoNumbers.add(createLotto())
        }
        return lottoNumbers.also { view.showPurchasedLotteries(it) }
    }

    fun retryGetWinningNumbers(lottoShop: LottoShop): Lotto {
        var winningNumbers: Lotto?
        do {
            view.showWinningNumber()
            winningNumbers = lottoShop.getWinningNumbers()
        } while (winningNumbers == null)
        return winningNumbers
    }

    fun getWinningNumbers(): Lotto? {
        val winningNumber = Console.readLine().trim().split(",").map { it.toInt() }
        return try {
            Lotto(winningNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    fun retryGetBonusNumber(lottoShop: LottoShop, winningNumbers: Lotto): Int {
        var bonusNumber: Int
        do {
            view.showBonusNumber()
            bonusNumber = lottoShop.getBonusNumber(winningNumbers)
        } while (bonusNumber == 0)
        return bonusNumber
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        val bonusNumber = Console.readLine().trim()
        return try {
            checkBonusNumber(winningNumbers, bonusNumber)
            bonusNumber.toInt().also { println(it) }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            0
        }
    }

    private fun createLotto(): Lotto = Lotto(createLottoNumbers().sorted())

    private fun createLottoNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(START, END, COUNT)

    companion object {
        private const val START = 1
        private const val END = 45
        private const val COUNT = 6
    }
}