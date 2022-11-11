package lotto.domain

import org.junit.jupiter.api.Test

@Suppress("NonASCIICharacters")
class LottoResultTest {

    private val lottoResult = makeLottoResult()

    @Test
    fun `당첨 정보에서 순위 별 개수를 구할 수 있어야 한다`() {
        val rankToCnt = lottoResult.rankToCnt

        val expect = mapOf(
            LottoRank.FIFTH to 1,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0,
            LottoRank.FAIL to 7
        )

        for ((rank, cnt) in rankToCnt) {
            assert(expect[rank] == cnt)
        }
    }

    @Test
    fun `로또의 총 수익률은 총 수익 나누기 구입금액 곱하기 100 이다`() {
        val profit = lottoResult.computeProfit()
        val input = String.format("%.1f", profit)
        val expect = "62.5"
        assert(input == expect)
    }

    companion object {
        private const val ORIGIN = 8000

        fun makeLottoResult(): LottoResult {
            val lottoNums = listOf(
                listOf(8, 21, 23, 41, 42, 43),
                listOf(3, 5, 11, 16, 32, 38),
                listOf(7, 11, 16, 35, 36, 44),
                listOf(1, 8, 11, 31, 41, 42),
                listOf(13, 14, 16, 38, 42, 45),
                listOf(7, 11, 30, 40, 42, 43),
                listOf(2, 13, 22, 32, 38, 45),
                listOf(1, 3, 5, 14, 22, 45)
            )
            val winningNumber = WinningNumber(
                listOf(1, 2, 3, 4, 5, 6),
                7
            )
            val lottos = lottoNums.map { Lotto(it) }
            return LottoResult(lottos, winningNumber, ORIGIN)
        }
    }
}