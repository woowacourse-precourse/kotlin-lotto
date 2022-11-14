package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveNumberVerifierTest {
    private lateinit var verifier: PositiveNumberVerifier

    @BeforeEach
    fun setUp() {
        verifier = PositiveNumberVerifier()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, Integer.MAX_VALUE])
    fun `양수면 예외가 발생하지 않는다`(input: Int) {
        assertDoesNotThrow { verifier.verify(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `양수가 아니면 예외가 발생한다`(input: Int) {
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }
}