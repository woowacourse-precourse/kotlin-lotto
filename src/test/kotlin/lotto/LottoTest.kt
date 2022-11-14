package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest(){
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호의 개수가 6개가 넘지못하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `로또 번호에는 1부터 45 밖의 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
        assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `로또 번호 정상 작동`() {
        Lotto.lottos.clear()
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 번호 오름차순`() {
        Lotto.lottos.clear()
        Lotto(listOf(1, 2, 3, 6, 5, 4))
        val result = listOf(1,2,3,4,5,6)
        assertThat(Lotto.lottos[0]).isEqualTo(result)
    }

    @Test
    fun `로또 목록 출력`() {
        Lotto.lottos.clear()
        Lotto(listOf(1, 2, 3, 4, 5, 6))
        Lotto(listOf(1, 2, 3, 4, 5, 7))
        Lotto.printCount()
        assertThat(output()).contains(
            "2개를 구매했습니다.",
            "[1, 2, 3, 4, 5, 6]",
            "[1, 2, 3, 4, 5, 7]"
        )
    }

    @Test
    fun `랜덤 발행`() {
        Lotto.lottos.clear()
        Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                Lotto.publish(3)
                Lotto.printCount()
                assertThat(output()).contains(
                    "3개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]"
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44)
        )
    }
    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
