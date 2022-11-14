package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
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
    fun `입력받은 당첨 번호를 쉼표 기준으로 나눠 정수 리스트로 변경한다`() {
        val result = LottoViewModel.changeToIntList("1,2,3,4,5")
        Assertions.assertThat(result).isEqualTo(WINNING_NUMBER)
    }

    @Test
    fun `당첨 번호와 발행된 번호를 리스트로 합친다`() {
        val result = LottoViewModel.getMergeList(WINNING_NUMBER, mutableListOf(1, 2, 3))
        Assertions.assertThat(result).isEqualTo(MERGE_LIST)
    }

    @Test
    fun `당첨 번호와 발행된 번호를 합친 리스트에서 중복된 숫자를 출력한다`() {
        val result = LottoViewModel.getMatchedNumbers(MERGE_LIST)
        Assertions.assertThat(result).isEqualTo(listOf(1, 2, 3))
    }

    companion object {
        private val WINNING_NUMBER = listOf(1, 2, 3, 4, 5)
        private val MERGE_LIST = listOf(1, 2, 3, 4, 5, 1, 2, 3)
    }
}
