package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    val answer = Lotto(listOf(1, 5, 14, 22, 33, 41))

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
    fun `로또 번호가 1에서 45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 48, 5, 7, 9))
        }
    }

    @Test
    fun `로또 번호가 당첨 번호와 3개 일치`() {
        val user = Lotto(listOf(1, 2, 14, 22, 37, 38))
        val result = 3

        assertThat(user.countCompareLotto(answer)).isEqualTo(result)
    }

    @Test
    fun `로또 번호가 당첨 번호와 4개 일치`() {
        val user = Lotto(listOf(1, 2, 14, 22, 33, 38))
        val result = 4

        assertThat(user.countCompareLotto(answer)).isEqualTo(result)
    }

    @Test
    fun `로또 번호가 당첨 번호와 5개 일치`() {
        val user = Lotto(listOf(1, 2, 14, 22, 33, 41))
        val result = 5

        assertThat(user.countCompareLotto(answer)).isEqualTo(result)
    }

    @Test
    fun `로또 번호가 당첨 번호와 6개 일치`() {
        val user = Lotto(listOf(1, 5, 14, 22, 33, 41))
        val result = 6

        assertThat(user.countCompareLotto(answer)).isEqualTo(result)
    }
}
