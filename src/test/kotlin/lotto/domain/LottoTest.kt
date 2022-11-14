package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class LottoTest {

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

        @Nested
        inner class `주어지는 로또 번호가 1에서 45 사이의 숫자가 아니면` {
            private val numbers = listOf(1, 2, 3, 4, 5, 46)

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { Lotto(numbers) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `주어지는 로또 번호 중 중복된 숫자가 있다면` {
            private val numbers = listOf(1, 2, 3, 4, 5, 5)

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { Lotto(numbers) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `로또 번호를 받으면` {
            private val numbers = listOf(6, 5, 4, 3, 2, 1)

            @Test
            fun `오름차순으로 정렬한다`() {
                val lotto = Lotto(numbers)

                assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6)
            }
        }
    }
}
