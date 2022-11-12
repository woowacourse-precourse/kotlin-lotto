package lotto.ui

import lotto.domain.LottoResultTest
import org.junit.jupiter.api.Test

@Suppress("NonASCIICharacters")
class LottoResultFormatterTest {

    @Test
    fun `당첨 통계 테스트`() {
        val formatter = LottoResultFormatter(makeLottoResult())
        val result = formatter.getStatInfo()
        val expects = listOf(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개"
        )
        assert(expects.all { it in result })
    }

    @Test
    fun `총 수익률 테스트`() {
        val formatter = LottoResultFormatter(makeLottoResult())
        val result = formatter.getProfitInfo()
        val expect = "총 수익률은 62.5%입니다."
        assert(result == expect)
    }

    companion object {
        fun makeLottoResult() = LottoResultTest.makeLottoResult()
    }
}
