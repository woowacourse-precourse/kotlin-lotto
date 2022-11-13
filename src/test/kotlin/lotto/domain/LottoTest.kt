package lotto.domain

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class `Lotto 클래스의` {

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Nested
    inner class `생성자는` {
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `주어지는 로또 번호의 개수가 6개가 아니면` {
            private fun numbers() = listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7))
            )
            @ParameterizedTest
            @MethodSource("numbers")
            fun `예외를 던진다`(numbers: List<Int>) {
                assertThatThrownBy { Lotto(numbers) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
}
