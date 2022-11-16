package lotto.domain

import lotto.enum.WinningRank
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoGameTest {
    lateinit var lottoGame: LottoGame
    lateinit var winningLotto: Lotto
    lateinit var bonusNumber: BonusNumber
    lateinit var userLotto: LottoList

    @BeforeEach
    fun `lottoGame, winningLotto, bonusNumber, userLotto 초기화`() {
        winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        bonusNumber = BonusNumber(7)
        userLotto = LottoList(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(10, 12, 13, 14, 15, 16)),
                Lotto(listOf(1, 2, 3, 14, 15, 16))
            )
        )
        lottoGame = LottoGame(winningLotto, bonusNumber, userLotto)
    }

    @Test
    fun `calculateTotalReward 메서드에 당첨 결과를 인자로 넘겨 총 당첨 금액을 구한다`() {
        val method =
            lottoGame.javaClass.getDeclaredMethod("calculateTotalReward", Map::class.java)
        method.isAccessible = true
        val input = userLotto.compare(winningLotto, bonusNumber)
        val result = method.invoke(lottoGame, input)
        assertThat(result).isEqualTo(2_030_005_000)
    }

    @Test
    fun `calculateEarningRate 메서드에 총 당첨 금액을 인자로 넘겨 수익률을 구한다`() {
        val method =
            lottoGame.javaClass.getDeclaredMethod("calculateEarningRate", Int::class.java)
        method.isAccessible = true
        val input = 5000
        val result = method.invoke(lottoGame, input)
        assertThat(result).isEqualTo(125.0)
    }

    @Test
    fun `play 메서드를 사용해 로또 게임을 진행한 결과를 반환`() {
        val result = lottoGame.play()
        println(result)
        assertThat(result).isEqualTo(listOf(1, 0, 0, 1, 1) to 50_750_125.0)
    }

}