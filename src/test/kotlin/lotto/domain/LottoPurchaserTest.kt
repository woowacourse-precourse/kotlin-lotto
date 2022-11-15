package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonASCIICharacters")
class LottoPurchaserTest {

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
            val lottoPurchaser = LottoPurchaser(cost)
            val lottos = lottoPurchaser.purchaseLottos()
            assert(lottos.size == expects[idx])
        }
    }

    @Test
    fun `로또를 1개도 구매할 수 없는 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            val lottoPurchaser = LottoPurchaser(999)
            lottoPurchaser.purchaseLottos()
        }
    }

    @Test
    fun `로또 가격으로 나누어 떨어지지 않는 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            val lottoPurchaser = LottoPurchaser(5500)
            lottoPurchaser.purchaseLottos()
        }
    }
}
