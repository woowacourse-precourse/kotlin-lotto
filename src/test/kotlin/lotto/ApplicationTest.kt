package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `애플리케이션 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "구입금액을 입력해 주세요.",
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "당첨 번호를 입력해 주세요.",
                    "보너스 번호를 입력해 주세요.",
                    "당첨 통계",
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
    fun `로또 결과 계산 테스트 1, 당첨번호와 랜덤 로토 번호를 비교해 각 등수별 당첨 개수 계산`() {
        assertSimpleTest {
            val ranking = getRankedLotto(listOf(
                Lotto(listOf(8, 21, 23, 41, 42, 43)),
                Lotto(listOf(3, 5, 11, 16, 32, 38)),
                Lotto(listOf(7, 11, 16, 35, 36, 44)),
                Lotto(listOf(1, 8, 11, 31, 41, 42)),
                Lotto(listOf(13, 14, 16, 38, 42, 45)),
                Lotto(listOf(7, 11, 30, 40, 42, 43)),
                Lotto(listOf(2, 3, 22, 32, 38, 45)),
                Lotto(listOf(1, 3, 5, 14, 22, 45)),
            ), listOf(1,3,5,14,22,38), 45)
            assertThat(ranking).isEqualTo(mapOf(Pair(Rank.THIRD, 1), Pair(Rank.FIFTH, 2)))
        }
    }

    @Test
    fun `로또 결과 계산 테스트 2, 총 당첨 개수를 활용한 총 상금 계산`() {
        assertSimpleTest {
            val prizeAmount =  getTotalPrizeAmount(mutableMapOf(Pair(Rank.THIRD, 1), Pair(Rank.FIFTH, 2)))
            assertThat(prizeAmount).isEqualTo(1510000)
        }
    }

    @Test
    fun `로또 결과 계산 테스트 3, 총 상금을 활용한 수익률 계산`() {
        assertSimpleTest {
            val yieldPercent = getYieldPercent(1510000, 120000)
            assertThat(yieldPercent).isEqualTo(1258.33)
        }
    }

    override fun runMain() {
        main()
    }
}
