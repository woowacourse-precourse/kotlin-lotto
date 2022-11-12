package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


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
    @Test
    fun `first place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.FIRST_PLACE)
    }

    @Test
    fun `second place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 7))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.SECOND_PLACE)
    }

    @Test
    fun `third place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.THIRD_PLACE)
    }

    @Test
    fun `fourth place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 43, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.FOURTH_PLACE)
    }

    @Test
    fun `fifth place check`() {
        assertThat(Lotto(listOf(1, 2, 32, 43, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.FIFTH_PLACE)
    }

    @Test
    fun `none check with two numbers are matched`(){
        assertThat(Lotto(listOf(1, 2, 32, 43, 7, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.NONE)
    }

    @Test
    fun `none check with a number is matched`(){
        assertThat(Lotto(listOf(1, 7, 32, 43, 8, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoStatus.NONE)
    }

}
