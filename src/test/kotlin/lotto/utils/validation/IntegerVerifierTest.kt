package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class IntegerVerifierTest {
    private lateinit var verifier: IntegerVerifier

    @BeforeEach
    fun setUp() {
        verifier = IntegerVerifier()
    }

    @ParameterizedTest
    @ValueSource(strings = ["2147483000", "8000", "0001000", Int.MAX_VALUE.toString()])
    fun `정수면 예외가 발생하지 않는다`(input: String) {
        assertDoesNotThrow { verifier.verify(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2147484000", "10000a", "0 1000", "a b", Long.MAX_VALUE.toString()])
    fun `정수가 아니면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }
}