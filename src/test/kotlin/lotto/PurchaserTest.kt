package lotto

import org.junit.jupiter.api.Test

class PurchaserTest {
    private val purchaser = Purchaser()

    @Test
    fun `로또 비교 로직 확인`() {
        val lottos = listOf<Lotto>(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val winningNumbers = listOf<Int>(6, 7, 8, 9, 10, 11)
        val bonusNumber = 11
        purchaser.determineRank(lottos, winningNumbers, bonusNumber)
        for (i in purchaser.rankResult.keys) {
            i.printLottoResult(purchaser.rankResult[i]!!)
        }
    }
}
