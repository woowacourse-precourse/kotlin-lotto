package lotto.utils.validation

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ListSizeVerifierTest {
    private lateinit var verifier: ListSizeVerifier

    @BeforeEach
    fun setUp() {
        verifier = ListSizeVerifier(SIZE)
    }

    @Test
    fun `리스트 크기가 6 이면 예외가 발생하지 않는다`() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { verifier.verify(input) }
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `리스트 크기가 6이 아니면 예외가 발생한다`(input: List<Int>) {
        assertThrows<IllegalArgumentException> { verifier.verify(input) }
    }

    companion object {
        const val SIZE = 6

        @JvmStatic
        private fun generateData() = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7)
        )
    }
}