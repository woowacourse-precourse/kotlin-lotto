package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
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

    // 아래에 추가 테스트 작성 가능
    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 30))

    @Test
    fun `당첨번호와 일치율 확인`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThat(lotto.checkWinningNumbersMatching(winningNumbers))
            .isEqualTo(5)
    }

    @Test
    fun `보너스 번호와 일치하는지 확인`() {
        val bonusNumber = 30

        assertThat(lotto.checkBonusNumberMatching(bonusNumber))
            .isEqualTo(true)
    }

    @Test
    fun `로또 숫자 반환 확인`() {
        assertThat(lotto.returnNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 30))
    }
}
