package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat


class LottoTest : NsTest() {
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
    fun `로또 번호는 오름차순으로 출력되어야 한다`() {
        assertThat(Lotto(listOf(6,5,4,3,2,1)).lottoToString()).contains("[1, 2, 3, 4, 5, 6]")
        assertThat(Lotto(listOf(1,5,4,3,2,6)).lottoToString()).contains("[1, 2, 3, 4, 5, 6]")
        assertThat(Lotto(listOf(2,5,3,4,1,6)).lottoToString()).contains("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `로또 번호가 1부터 45사이가 아니면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `일치하는 번호 개수에 맞게 당첨 여부를 판단한다`() {
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,3,4,5,6), 8))
            .isEqualTo(Prize.FIRST)
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,3,4,5,7), 6))
            .isEqualTo(Prize.SECOND)
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,3,4,5,7), 8))
            .isEqualTo(Prize.THIRD)
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,3,4,7,8), 6))
            .isEqualTo(Prize.FOURTH)
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,3,7,8,9), 6))
            .isEqualTo(Prize.FIFTH)
        assertThat(Lotto(listOf(6,5,4,3,2,1)).winLottery(listOf(1,2,7,8,9,10), 6))
            .isEqualTo(Prize.NOTHING)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}