package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class WinningStatisticsTest : NsTest() {
    @Test
    fun `당첨 통계 출력 테스트`() {
        WinningStatistics.clear()
        assertSimpleTest {
            WinningStatistics.WIN3.count++
            WinningStatistics.print(20000)
            assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 25.0%입니다."

            )
        }
    }

    @Test
    fun `당첨 통계 출력 테스트2`() {
        WinningStatistics.clear()
        assertSimpleTest {
            WinningStatistics.WIN3.count += 2
            WinningStatistics.WIN4.count++
            WinningStatistics.print(13000)
            assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 461.5%입니다."
            )
        }
    }

    @Test
    fun `수익률 음수 예외 테스트`() {
        WinningStatistics.clear()
        assertThrows<IllegalArgumentException> {
            WinningStatistics.WIN3.count--
            WinningStatistics.print(13000)
        }
        assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `수익률 소수 자릿수 예외 테스트`() {
        WinningStatistics.clear()
        assertThrows<IllegalArgumentException> {
            WinningStatistics.WIN3.count++
            WinningStatistics.roundUnit = 100
            WinningStatistics.print(13000)
        }
        assertThat(output()).contains(ERROR_MESSAGE)
    }

    @Test
    fun `당첨 개수 세기 테스트`() {
        WinningStatistics.clear()
        LottoWin.NUM1.number = 1
        LottoWin.NUM2.number = 2
        LottoWin.NUM3.number = 3
        LottoWin.NUM4.number = 4
        LottoWin.NUM5.number = 5
        LottoWin.NUM6.number = 6
        LottoWin.BONUS.number = 7
        val lottoes =
            listOf(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 7, 8, 9), listOf(1, 2, 3, 5, 6, 7))
        WinningStatistics.calculateWin(lottoes)
        assertThat(WinningStatistics.WIN3.count).isEqualTo(1)
        assertThat(WinningStatistics.WIN5Bonus.count).isEqualTo(1)
        assertThat(WinningStatistics.WIN6.count).isEqualTo(1)
    }

    @Test
    fun `당첨 개수 세기 테스트2`() {
        WinningStatistics.clear()
        LottoWin.NUM1.number = 1
        LottoWin.NUM2.number = 2
        LottoWin.NUM3.number = 3
        LottoWin.NUM4.number = 4
        LottoWin.NUM5.number = 5
        LottoWin.NUM6.number = 6
        LottoWin.BONUS.number = 7
        val lottos =
            listOf(listOf(1, 2, 3, 4, 5, 8), listOf(1, 2, 3, 7, 8, 9), listOf(1, 2, 9, 10, 11, 12))
        WinningStatistics.calculateWin(lottos)
        assertThat(WinningStatistics.WIN3.count).isEqualTo(1)
        assertThat(WinningStatistics.WIN5.count).isEqualTo(1)
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}