package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {
    @Test
    fun `당첨 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `당첨 로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `당첨 로또 번호의 개수가 6개이고 중복되지 않으면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) })
        }
    }

    @Test
    fun `당첨 로또 번호 출시 대괄호로 감싸고 콤마로 구분된 문자열을 출력한다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) })
        assertEquals(
            winningLotto.toString(),
            "[1, 2, 3, 4, 5, 6]"
        )
    }

    @DisplayName("1등 당첨된 경우")
    @Test
    fun `로또 번호 6자리와 당첨 번호가 일치하면 FIRST 반환한다`() {
        val purchasedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }
        val lotto = Lotto(purchasedLottoNumbers)

        val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }
        val winningLotto = WinningLotto(winningLottoNumbers)
        val bonusNumber = LottoNumber(7)

        val rank = winningLotto.compareLottoRank(lotto = lotto, bonusNumber = bonusNumber)
        assertEquals(rank, LottoRank.FIRST)
    }

    @DisplayName("2등 당첨된 경우")
    @Test
    fun `로또 번호 5자리와 당첨 번호 및 보너스 번호가 일치하면 SECOND 반환한다`() {
        val purchasedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }
        val lotto = Lotto(purchasedLottoNumbers)

        val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 45).map { number -> LottoNumber(number) }
        val winningLotto = WinningLotto(winningLottoNumbers)
        val bonusNumber = LottoNumber(6)

        val rank = winningLotto.compareLottoRank(lotto = lotto, bonusNumber = bonusNumber)
        assertEquals(rank, LottoRank.SECOND)
    }

    @DisplayName("3등 당첨된 경우")
    @Test
    fun `로또 번호 5자리와 당첨 번호가 일치하면 THIRD 반환한다`() {
        val purchasedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }
        val lotto = Lotto(purchasedLottoNumbers)

        val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 45).map { number -> LottoNumber(number) }
        val winningLotto = WinningLotto(winningLottoNumbers)
        val bonusNumber = LottoNumber(44)

        val rank = winningLotto.compareLottoRank(lotto = lotto, bonusNumber = bonusNumber)
        assertEquals(rank, LottoRank.THIRD)
    }

    @DisplayName("4등 당첨된 경우")
    @Test
    fun `로또 번호 4자리와 당첨 번호가 일치하면 FOURTH 반환한다`() {
        val purchasedLottoNumbers = listOf(1, 2, 3, 4, 10, 11).map { number -> LottoNumber(number) }
        val lotto = Lotto(purchasedLottoNumbers)

        val winningLottoNumbers = listOf(1, 2, 3, 4, 44, 45).map { number -> LottoNumber(number) }
        val winningLotto = WinningLotto(winningLottoNumbers)
        val bonusNumber = LottoNumber(43)

        val rank = winningLotto.compareLottoRank(lotto = lotto, bonusNumber = bonusNumber)
        assertEquals(rank, LottoRank.FOURTH)
    }

    @DisplayName("5등 당첨된 경우")
    @Test
    fun `로또 번호 3자리와 당첨 번호가 일치하면 FIFTH 반환한다`() {
        val purchasedLottoNumbers = listOf(1, 2, 3, 10, 11, 12).map { number -> LottoNumber(number) }
        val lotto = Lotto(purchasedLottoNumbers)

        val winningLottoNumbers = listOf(1, 2, 3, 43, 44, 45).map { number -> LottoNumber(number) }
        val winningLotto = WinningLotto(winningLottoNumbers)
        val bonusNumber = LottoNumber(42)

        val rank = winningLotto.compareLottoRank(lotto = lotto, bonusNumber = bonusNumber)
        assertEquals(rank, LottoRank.FIFTH)
    }
}