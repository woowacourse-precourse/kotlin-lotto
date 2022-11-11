package lotto.domain

import org.junit.jupiter.api.Test

@Suppress("NonASCIICharacters")
class LottoRankerTest {
    private val ranker = LottoRanker()

    @Test
    fun `당첨 등수 검사`() {
        val winningNumber = WinningNumber(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            7
        )
        val lottoNums = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 44),
            listOf(1, 2, 3, 4, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
        val expects = listOf(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FAIL,
            LottoRank.FAIL,
            LottoRank.FAIL,
            LottoRank.FIFTH
        )

        for ((idx, lottoNum) in lottoNums.withIndex()) {
            val lotto = Lotto(lottoNum)
            assert(
                ranker.rank(lotto, winningNumber) == expects[idx]
            )
        }
    }
}