package lotto

import lotto.domain.LottoPurchaser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonASCIICharacters")
class LottoPurchaserTest {

    private val lottoPurchaser = LottoPurchaser()

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
            val lottos = lottoPurchaser.purchaseLottos(cost)
            assert(lottos.size == expects[idx])
        }
    }

    @Test
    fun `로또를 1개도 구매할 수 없는 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            lottoPurchaser.purchaseLottos(999)
        }
    }

    @Test
    fun `로또 가격으로 나누어 떨어지지 않는 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            lottoPurchaser.purchaseLottos(5500)
        }
    }
}
