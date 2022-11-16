package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExpectedNumberGeneratorTest {
    private val answers = listOf(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12), listOf(13, 14, 15, 16, 17, 18))
    private lateinit var generator: ExpectedNumberGenerator

    @BeforeEach
    fun setUp() {
        generator = ExpectedNumberGenerator(answers)
    }

    @Test
    fun `원하는 숫자를 가진 리스트를 넘겨주면 반환해준다`() {
        for (expected in answers) {
            val actual = generator.generateNumbers()
            assertThat(actual).isEqualTo(expected)
        }
    }
}