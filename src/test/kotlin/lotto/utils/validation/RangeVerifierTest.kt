package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RangeVerifierTest {
    private lateinit var verifier: RangeVerifier

    @BeforeEach
    fun setUp() {
        verifier = RangeVerifier(MIN, MAX)
    }

    @Test
    fun `1과 45사이의 숫자면 예외가 발생하지 않는다`() {
        val input = 45
        assertDoesNotThrow { verifier.verify(input) }
    }

    @Test
    fun `1과 45사이의 숫자가 아니면 예외가 발생한다`() {
        val input = 46
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }
}