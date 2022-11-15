package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.constants.earningRateMSG
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `로또 구입 금액 1000원 단위가 아닐 경우`(){
        assertSimpleTest {
            runException("1111")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 번호 오름차순 출력 test`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "[1, 2, 3, 4, 5, 6]"
                )
            },
            listOf(1, 6, 3, 4, 5, 2)
        )
    }
    @Test
    fun `로또 개수가 구입한 가격에 맞게 계산되는지 test`(){
        assertThat(User("10000").numOfLotto).isEqualTo(10)
    }

    @Test
    fun `로또 당첨 test1 - 1등`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 6)
        )
    }
    @Test
    fun `로또 당첨 test2 - 2등`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 0개",
                )
            },
            listOf(1, 2, 3, 4, 5, 7)
        )
    }
    @Test
    fun `로또 당첨 test3 - 3등`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                )
            },
            listOf(1, 2, 3, 4, 6, 8)
        )
    }
    @Test
    fun `로또 당첨 test4 - 4등`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                )
            },
            listOf(1, 2, 3, 4, 7, 8)
        )
    }
    @Test
    fun `로또 당첨 test5 - 5등`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                )
            },
            listOf(1, 2, 3, 10, 7, 8)
        )
    }
    @Test
    fun `로또 당첨 test6 - 1등부터 5등까지 하나씩 걸렸을 때`(){
        assertRandomUniqueNumbersInRangeTest(
            {
                run("5000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개",
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 10),
            listOf(1, 2, 3, 4, 7, 8),
            listOf(1, 2, 3, 10, 7, 8)
        )
    }
    @Test
    fun `로또 당첨금이 매우 클 경우의 수익률`(){
        assertThat(earningRateMSG(200000000000.0)).isEqualTo("총 수익률은 200000000000%입니다.")
    }
    @Test
    fun `수익률이 소수점 둘째 자리에서 정상적으로 반올림 되는지 test`(){
        assertThat(calcEarningRate(5000,7000)).isEqualTo(71.4)
    }

    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
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
