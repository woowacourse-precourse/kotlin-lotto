package lotto

import lotto.domain.store.Cacher
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
    fun `로또를 개수에 맞게 생산했는지 확인`() {
        cacher.receiveMoney(10000)
        val lotteries = cacher.returnCreatedLotteries()
        assertThat(lotteries).hasSize(10)
    }

    @Test
    fun `생성된 로또에 중복값이 없는지 확인`(){
        cacher.receiveMoney(5000)
        val lottereis = cacher.returnCreatedLotteries()
        assertThat(lottereis.toSet().size).isEqualTo(cacher.numberOfLotteries)
    }
}
