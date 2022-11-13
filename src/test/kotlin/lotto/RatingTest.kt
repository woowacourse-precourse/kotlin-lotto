package lotto

import lotto.domain.Rating
import org.junit.jupiter.api.Test

class RatingTest {
    @Test
    fun `Rating 추상 메서드 테스트`() {
        val test = Rating.values()[0].getHit()
        println(test)
    }
}