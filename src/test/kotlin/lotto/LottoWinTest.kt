package lotto

import lotto.domain.LottoPrize
import lotto.domain.LottoWin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LottoWinTest {

    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @Test
    fun `로또 수익률 계산 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        LottoWin().printProfitRate(8000, 5000)

        val output = outputStreamCaptor.toString()
        org.assertj.core.api.Assertions.assertThat(output).contains("62.5")
    }

    @Test
    fun `로또 상금 계산 테스트 - 3개 일치`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val lotto: List<Int> = listOf(1, 0, 0, 0, 0)
        LottoWin().printWinStats(lotto)

        val output = outputStreamCaptor.toString()
        org.assertj.core.api.Assertions.assertThat(output).contains("3개 일치 (5,000원) - 1개")
    }

    @Test
    fun `로또 상금 계산 테스트 - 4개 일치, 5개 일치`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val lotto: List<Int> = listOf(0, 1, 1, 0, 0)
        LottoWin().printWinStats(lotto)

        val output = outputStreamCaptor.toString()
        org.assertj.core.api.Assertions.assertThat(output).contains("4개 일치 (50,000원) - 1개")
        org.assertj.core.api.Assertions.assertThat(output).contains("5개 일치 (1,500,000원) - 1개")
    }

    @Test
    fun `로또 상금 계산 테스트 - 3개 일치, 6개 일치`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val lotto: List<Int> = listOf(2, 0, 0, 0, 1)
        LottoWin().printWinStats(lotto)

        val output = outputStreamCaptor.toString()
        org.assertj.core.api.Assertions.assertThat(output).contains("3개 일치 (5,000원) - 2개")
        org.assertj.core.api.Assertions.assertThat(output).contains("6개 일치 (2,000,000,000원) - 1개")
    }

    @Test
    fun `로또 6개 일치`() {
        val lotto = LottoWin().lottoRank(6, false)
        Assertions.assertEquals(lotto, LottoPrize.FIRST)
    }

    @Test
    fun `로또 5개 일치, 보너스 볼 일치`() {
        val lotto = LottoWin().lottoRank(5, true)
        Assertions.assertEquals(lotto, LottoPrize.SECOND)
    }

    @Test
    fun `로또 5개 일치`() {
        val lotto = LottoWin().lottoRank(5, false)
        Assertions.assertEquals(lotto, LottoPrize.THIRD)
    }

    @Test
    fun `로또 4개 일치`() {
        val lotto = LottoWin().lottoRank(4, false)
        Assertions.assertEquals(lotto, LottoPrize.FOURTH)
    }

    @Test
    fun `로또 3개 일치`() {
        val lotto = LottoWin().lottoRank(3, false)
        Assertions.assertEquals(lotto, LottoPrize.FIFTH)
    }

}