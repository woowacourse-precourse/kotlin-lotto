package lotto

import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.domain.LottoRank
import lotto.domain.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


// TODO: 에러 메시지 프리픽스 검사
@Suppress("NonASCIICharacters")
class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개보다 적다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45까지의 수가 아닌 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 0, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 자동 생성 시 예외가 발생하면 안된다`() {
        assertDoesNotThrow {
            LottoFactory.generate()
        }
    }

    @Test
    fun `당첨 등수 검사`() {
        val winningNumber = WinningNumber(
            listOf(1, 2, 3, 4, 5, 6),
            7
        )
        val lottoNums = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 44),
            listOf(1, 2, 3, 4, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
        val expects = listOf(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FAIL,
            LottoRank.FAIL,
            LottoRank.FAIL,
            LottoRank.FIFTH
        )

        for ((idx, lottoNum) in lottoNums.withIndex()) {
            val lotto = Lotto(lottoNum)
            assert(
                lotto.getLottoRank(winningNumber) == expects[idx]
            )
        }
    }
}
