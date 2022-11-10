package lotto

import org.junit.jupiter.api.Test

class LottoProviderTest {

    private val lottoProvider = LottoProvider()

    @Test
    fun `특정 금액을 로또 가격으로 나눈 수 만큼 로또를 구입한다`() {
        val inputs = listOf(
            1000,
            2000,
            3000,
            15000,
            100000
        )
        val expects = listOf(
            1,
            2,
            3,
            15,
            100
        )

        for ((idx, cost) in inputs.withIndex()) {
            val lottos = lottoProvider.provideLottos(cost)
            assert(lottos.size == expects[idx])
        }
    }
}