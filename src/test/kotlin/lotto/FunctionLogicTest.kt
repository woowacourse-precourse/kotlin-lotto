package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.round

class FunctionLogicTest {
    @Test
    fun `입력받은 당첨 번호를 쉼표 기준으로 나눠 정수 리스트로 변경한다`() {
        assertThat(listOf(1, 2, 3, 4, 5)).isEqualTo(LottoViewModel.changeToIntList("1,2,3,4,5"))
    }

    @Test
    fun `당첨 번호와 발행된 번호를 리스트로 합친다`() {
        assertThat(listOf(1, 2, 3, 4, 5, 1, 2, 3, 11, 12)).isEqualTo(
            getMergeList(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 11, 12)
            )
        )
    }

    @Test
    fun `당첨 번호와 발행된 번호를 합친 리스트에서 중복된 숫자를 출력한다`() {
        assertThat(listOf(1, 2, 3)).isEqualTo(LottoViewModel.getMatchedNumbers(listOf(1, 2, 3, 4, 5, 1, 2, 3)))
    }

    @Test
    fun `총 수익률은 소수점 둘째 자리에서 반올림하여 출력한다`() {
        assertThat(62.5).isEqualTo(getProfit(62.46))
    }

    private fun getMergeList(winningNumberList: List<Int>, issuedNumbers: List<Int>): List<Int> =
        listOf(winningNumberList, issuedNumbers).flatMap { it.orEmpty() }

    private fun getProfit(profit: Double): Double = round(profit * 10) / 10
}