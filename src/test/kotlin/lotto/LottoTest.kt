package lotto

import lotto.domain.lotto.Lotto
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

    @Test
    fun `로또 번호가 오름차순이 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>{
            Lotto(listOf(1, 3, 2, 4, 5, 6))
        }
    }

    @Test
    fun `당첨 번호와 로또 번호를 비교해서 일치하는 개수`() {
        val lottNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = Lotto(lottNumbers).getMachingLottoNumberCount(winningNumbers)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `당첨 번호에 보너스 번호가 포함되는지 확인하는 테스트`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 2
        val result = Lotto(lottoNumbers).isMachingBonusNumber(bonusNumber)
        assertThat(result).isEqualTo(true)
    }
}
