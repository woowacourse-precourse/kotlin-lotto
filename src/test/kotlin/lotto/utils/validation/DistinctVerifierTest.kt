package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class DistinctVerifierTest {
    private lateinit var verifier: DistinctVerifier

    @BeforeEach
    fun setUp() {
        verifier = DistinctVerifier()
    }

    @Test
    fun `중복되는 수가 없으면 예외가 발생하지 않는다`() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { verifier.verify(input) }
    }

    @Test
    fun `중복되는 수가 있으면 예외가 발생한다`() {
        val input = listOf(10, 2, 3, 4, 5, 10)
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }
}