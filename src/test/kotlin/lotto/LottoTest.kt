package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    val answer = Lotto(listOf(1, 5, 14, 22, 33, 41))
    val bonus = 3

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
    @Test
    fun `당첨 결과가 5등인지 확인`() {
        val user = Lotto(listOf(1, 7, 14, 25, 33, 42))
        val result = LottoGrade.FIFTH

        assertThat(user.matchLotto(answer,bonus)).isEqualTo(result)
    }

    @Test
    fun `당첨 결과가 4등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 25, 33, 42))
        val result = LottoGrade.FOURTH

        assertThat(user.matchLotto(answer,bonus)).isEqualTo(result)
    }

    @Test
    fun `당첨 결과가 3등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 25, 33, 41))
        val result = LottoGrade.THIRD

        assertThat(user.matchLotto(answer,bonus)).isEqualTo(result)
    }

    @Test
    fun `당첨 결과가 2등인지 확인`() {
        val user = Lotto(listOf(1, 3, 5, 14, 33, 41))
        val result = LottoGrade.SECOND

        assertThat(user.matchLotto(answer,bonus)).isEqualTo(result)
    }

    @Test
    fun `당첨 결과가 1등인지 확인`() {
        val user = Lotto(listOf(1, 5, 14, 22, 33, 41))
        val result = LottoGrade.FIRST

        assertThat(user.matchLotto(answer,bonus)).isEqualTo(result)
    }
}
