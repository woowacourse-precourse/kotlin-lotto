package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest() {

    @Test
    fun `로또 구입 기능 단위 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("2000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "2개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
        )
    }


    // 단위 예외 처리 테스트
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
    fun `로또 번호가 1미만일 경우 예외가 발생한다`() {
        assertThrows<java.lang.IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 45))
        }
    }

    @Test
    fun `로또 번호가 45초과일 경우 예외가 발생한다`() {
        assertThrows<java.lang.IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 5, 46, 47))
        }
    }

    @Test
    fun `로또 번호가 6개 이하 경우 예외가 발생한다`() {
        assertThrows<java.lang.IllegalArgumentException> {
            Lotto(listOf(5, 6, 10))
        }
    }

    @Test
    fun `로또 번호가 1 미만시 예외가 발생한다`() {
         assertThrows<IllegalArgumentException>  {
            run("5000", "0,2,3,4,5,6", "7")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 번호가 45 초과시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            run("5000", "40,42,43,44,45,46", "7")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액이 천원단위가 아닐시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            run("1231231321")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 번호와 보너스 번호가 같을시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            run("5000", "21,22,23,24,25,26", "26")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
