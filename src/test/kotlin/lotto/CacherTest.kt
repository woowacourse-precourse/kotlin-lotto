package lotto

import lotto.domain.Cacher
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CacherTest {
    private val cacher = Cacher()

    @Test
    fun `돈을 받고 로또의 개수를 계산한다`() {
        cacher.receiveMoney(23000)
        assertThat(cacher.numberOfLotteries).isEqualTo(23)
    }

    @Test
    fun `개수만큼 로또 발행`() {
        cacher.receiveMoney(23000)
        val result = cacher.returnCreatedLotteries()
        assertThat(result).hasSize(23)
    }
}
