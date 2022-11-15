package lotto

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
    @Test
    fun `first place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.FIRST_PLACE)
    }

    @Test
    fun `second place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 7))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.SECOND_PLACE)
    }

    @Test
    fun `third place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.THIRD_PLACE)
    }

    @Test
    fun `fourth place check`() {
        assertThat(Lotto(listOf(1, 2, 3, 43, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.FOURTH_PLACE)
    }

    @Test
    fun `fifth place check`() {
        assertThat(Lotto(listOf(1, 2, 32, 43, 5, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.FIFTH_PLACE)
    }

    @Test
    fun `none check with two numbers are matched`(){
        assertThat(Lotto(listOf(1, 2, 32, 43, 7, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.NONE)
    }

    @Test
    fun `none check with a number is matched`(){
        assertThat(Lotto(listOf(1, 7, 32, 43, 8, 45))
            .checkLotto(listOf(1, 2, 3, 4, 5, 6), 7))
            .isEqualTo(LottoPlace.NONE)
    }

}
