package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RangeVerifierTest {
    private lateinit var verifier: RangesVerifier

    @BeforeEach
    fun setUp() {
        verifier = RangesVerifier(MIN, MAX)
    }

    @Test
    fun `1과 45사이의 숫자로만 이루어져 있으면 예외가 발생하지 않는다`() {
        val input = listOf(1, 3, 5, 7, 22, 45)
        assertDoesNotThrow { verifier.verify(input) }
    }

    @Test
    fun `1과 45사이의 숫자가 아닌 수가 포함되어 있으면 예외가 발생한다`() {
        val input = listOf(1, 3, 5, 7, 22, 46)
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }
}