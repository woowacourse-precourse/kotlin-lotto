package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class WinningNumberTest {
    @Nested
    inner class `생성자는` {
        @Nested
        inner class `당첨 번호들의 개수가 6이 아니면` {
            private val winningNumbers = listOf(1, 2, 3, 4, 5, 6, 7)
            private val bonusNumber = 45

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { WinningNumber(winningNumbers, bonusNumber) }
                    .isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `당첨 번호 중 어떤 번호가 1에서 45 사이의 숫자가 아니라면` {
            private val winningNumbers = listOf(1, 2, 3, 4, 5, 0)
            private val bonusNumber = 45

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { WinningNumber(winningNumbers, bonusNumber) }
                    .isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `당첨 번호가 중복되었다면` {
            private val winningNumbers = listOf(1, 2, 3, 4, 5, 5)
            private val bonusNumber = 45

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { WinningNumber(winningNumbers, bonusNumber) }
                    .isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `보너스 번호가 당첨 번호에 포함되었다면` {
            private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            private val bonusNumber = 6

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { WinningNumber(winningNumbers, bonusNumber) }
                    .isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
}