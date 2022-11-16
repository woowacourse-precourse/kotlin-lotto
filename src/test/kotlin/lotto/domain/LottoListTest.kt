package lotto.domain

import lotto.enum.WinningRank
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoListTest {
    lateinit var lottoList: LottoList

    @BeforeEach
    fun `lottoList 초기화`() {
        lottoList = LottoList(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(10, 12, 13, 14, 15, 16)),
                Lotto(listOf(1, 2, 3, 14, 15, 16))
            )
        )
    }

    @Test
    fun `purchaseAmount 메서드를 사용해 로또 구매 금액을 반환`() {
        val result = lottoList.purchaseAmount()
        assertThat(result).isEqualTo(4000)
    }

    @Test
    fun `getWinningRank 메서드에 일치하는 숫자 갯수와 보너스 번호 일치 여부를 인자로 주어 해당하는 WinningRank를 반환`() {
        val method =
            lottoList.javaClass.getDeclaredMethod("getWinningRank", Int::class.java, Boolean::class.java)
        method.isAccessible = true

        val inputMatches = 5
        val inputBonusMatch = true
        val result = method.invoke(lottoList, inputMatches, inputBonusMatch)
        assertThat(result).isEqualTo(WinningRank.SECOND)
    }

    @Test
    fun `compare 메서드에 당첨 번호와 보너스 번호를 인자로 구매 로또들의 당첨 여부를 확인`() {
        val inputWinningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val inputBonusNumber = BonusNumber(7)
        val result = lottoList.compare(inputWinningLotto, inputBonusNumber)
        assertThat(result).isEqualTo(
            mapOf(
                WinningRank.FIRST to 1,
                WinningRank.SECOND to 1,
                WinningRank.NOTHING to 1,
                WinningRank.FIFTH to 1
            )
        )
    }
}