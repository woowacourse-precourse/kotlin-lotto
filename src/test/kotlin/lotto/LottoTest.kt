package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    private lateinit var winningNumber: List<Int>

    @BeforeEach
    fun setUp() {
        winningNumber = listOf(1,2,3,4,5,6)
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `1부터 45 사이의 숫자를 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(49, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `당첨 내역 조회 테스트`() {
        val lotto = Lotto(winningNumber)
        val lottoNumbers = listOf(
            listOf(1,2,3,10,11,12), // 3개 일치
            listOf(1,2,3,4,11,12),  // 4개 일치
            listOf(1,2,3,4,5,8),    // 5개 일치
            listOf(1,2,3,4,5,7),    // 5개 일치, 보너스 볼 일치
            listOf(1,2,3,4,5,6)     // 6개 일치
        )
        val bonusNumber = 7
        val actual = lotto.getWinnerList(lottoNumbers, bonusNumber)
        val expected = listOf(1,1,1,1,1)
        assertThat(actual).isEqualTo(expected)
    }
}
