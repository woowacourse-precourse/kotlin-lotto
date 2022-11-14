package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1~45사이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 48))
        }
    }

    @Nested
    inner class GetPrizeTest() {
        @Test
        fun `당첨 번호와 로또번호를 비교하여 당첨금액을 계산한다`() {
            val winningNum = listOf(1, 2, 3, 4, 5, 6)
            val bonusNum = 7
            val lottoNums = listOf(
                listOf(1, 2, 3, 10, 11, 12) to 5_000,
                listOf(1, 2, 3, 4, 11, 12) to 50_000,
                listOf(1, 2, 3, 4, 5, 12) to 1_500_000,
                listOf(1, 2, 3, 4, 5, 6) to 2_000_000_000,
            )
            for ((nums, prize) in lottoNums) {
                assertThat(
                    Lotto(nums).getPrize(winningNum, bonusNum)
                ).isEqualTo(prize)
            }
        }

        @Test
        fun `당첨숫자와 5개의 로또번호가 일치할 때 보너스 볼을 체크하여 당첨금액을 계산한다`() {
            val winningNum = listOf(1, 2, 3, 4, 5, 6)
            val bonusNum = 7
            assertThat(
                Lotto(listOf(1, 2, 3, 4, 5, 45)).getPrize(
                    winningNum, bonusNum
                )
            ).isEqualTo(1_500_000)
            assertThat(
                Lotto(listOf(1, 2, 3, 4, 5, 7)).getPrize(
                    winningNum, bonusNum
                )
            ).isEqualTo(30_000_000)
        }
    }

}
