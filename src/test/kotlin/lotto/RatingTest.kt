package lotto

import lotto.enums.Rating
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RatingTest {
    @Test
    fun `Rating 메서드 - getHit 리턴 테스트`() {
        val test = Rating.values()[0].getHit()
        Assertions.assertThat(test.also { println(it) }).isEqualTo(6)
    }

    @Test
    fun `Rating 메서드 - getPrize 리턴 테스트`() {
        val test = Rating.values()[0].getPrize()
        Assertions.assertThat(test.also { println(it) }).isEqualTo(2_000_000_000)
    }

    @Test
    fun `Rating 메서드 - getBonus 리턴 테스트`() {
        val test = Rating.values()[0].getBonus()
        Assertions.assertThat(test.also { println(it) }).isEqualTo(false)
    }
}