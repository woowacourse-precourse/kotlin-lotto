package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class UniquenessVerifierTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private lateinit var verifier: UniquenessVerifier

    @BeforeEach
    fun setUp() {
        verifier = UniquenessVerifier(winningNumbers)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되지 않는 번호면 예외가 발생하지 않는다`() {
        val bonusNumber = 7
        assertDoesNotThrow { verifier.verify(bonusNumber) }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외가 발생한다`() {
        val bonusNumber = 6
        assertThrows<IllegalArgumentException> { verifier.verify(bonusNumber) }
    }
}