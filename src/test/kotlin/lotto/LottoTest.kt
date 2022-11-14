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

    @Test
    fun `로또 번호에 포함된 번호가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46)).checkNumber()
        }
    }

    @Test
    fun `모든 번호가 일치 하지 않을 때 반환 갯수 0개`() {
        val lottoList = Lotto(listOf(1,2,3,4,5,6))
        val matchCount = lottoList.updateMatchCount(
            listOf(1,2,3,4,5,6),
            listOf(7,8,9,10,11,12),
            13,
        )
        assertThat(0).isEqualTo(matchCount)

    }

    @Test
    fun `번호 5개와 보너스 번호가 일치할 때 7을 반환`() {
        val lottoList = Lotto(listOf(1,2,3,4,5,6))
        val matchCount = lottoList.updateMatchCount(
            listOf(1,2,3,4,5,6),
            listOf(1,2,3,4,5,7),
            7
        )
        assertThat(7).isEqualTo(matchCount)
    }



}