package lotto.domain

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

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호의 범위가 1 ~ 45 가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1,2,3,55,4,5))
        }
    }

    @Test
    fun `1등 당첨일 경우`(){
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.FIRST_PLACE)
    }

    @Test
    fun `2등 당첨일 경우`(){
        val lotto = Lotto(listOf(1,2,3,4,5,7))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.SECOND_PLACE)
    }

    @Test
    fun `3등 당첨일 경우`(){
        val lotto = Lotto(listOf(1,2,3,4,5,9))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.THIRD_PLACE)
    }
    @Test
    fun `4등 당첨일 경우`(){
        val lotto = Lotto(listOf(1,2,3,4,8,9))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.FOURTH_PLACE)
    }
    @Test
    fun `5등 당첨일 경우`(){
        val lotto = Lotto(listOf(1,2,3,8,9,10))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.FIFTH_PLACE)
    }

    @Test
    fun `낙첨일 경우`(){
        val lotto = Lotto(listOf(1,2,10,11,12,13))
        val winNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        assertThat(lotto.checkMyLotto(winNumbers, bonusNumber)).isEqualTo(Win.NO_LUCK)
    }
}
