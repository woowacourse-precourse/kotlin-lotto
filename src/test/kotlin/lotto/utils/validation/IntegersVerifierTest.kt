package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class IntegersVerifierTest {
    private lateinit var verifier: IntegersVerifier

    @BeforeEach
    fun setUp() {
        verifier = IntegersVerifier()
    }

    @Test
    fun `정수로만 이루어져 있으면 예외가 발생하지 않는다`() {
        val input = listOf("1", "2", "3", "4", "5", "6")
        assertDoesNotThrow { verifier.verify(input) }
    }

    @Test
    fun `정수가 아닌 문자열이 포함되어 있으면 예외가 발생한다`() {
        val input = listOf("1", "2", "3", "4", "5", "a")
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }
}