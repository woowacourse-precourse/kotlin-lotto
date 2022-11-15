package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

//이제야 존재를 알았다 :(  이것도 알고있었으면 정말 편했을텐데 너무 아쉽다.
//이제라도 사용법을 배워보자..

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

    @Test
    fun `번호 입력 기능 단위 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("2000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "당첨 번호를 입력해 주세요.",
                    "[1, 2, 3, 4, 5, 6]",
                    "보너스 번호를 입력해 주세요.",
                    "7",
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
        )
    }

    @Test
    fun `결과 출력 기능 단위 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("2000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "당첨 통계",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 0.0%입니다.",
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
        )
    }

    // 예외 처리 기능 단위 테스트 목록 /////////////////////////////////////////////////////////////////////////////////////
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
    fun `로또 번호가 45 초과시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호가 1 미만시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `로또 구입후 남은금액이 존재할시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            runException("1234")
            assertThat(output()).contains("[ERROR]")
        }
    }

    override fun runMain() {
        main()
    }
}