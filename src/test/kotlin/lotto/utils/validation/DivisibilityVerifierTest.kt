package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DivisibilityVerifierTest {
    private lateinit var verifier: DivisibilityVerifier

    @BeforeEach
    fun setUp() {
        verifier = DivisibilityVerifier(DIVISOR)
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 1234000, 50000000])
    fun `나누어 떨어지면 예외가 발생하지 않는다`(input: Int) {
        assertDoesNotThrow { verifier.verify(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1234, 15600, 1000008])
    fun `나누어 떨어지지 않으면 예외가 발생한다`(input: Int) {
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }

    companion object {
        const val DIVISOR = 1000
    }
}