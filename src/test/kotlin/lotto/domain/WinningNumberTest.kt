package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `WinningNumber 클래스의` {
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

    @Nested
    inner class `getWinningResult 메소드는` {
        @Nested
        inner class `당첨 번호와 로또 번호가 모두 일치하면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            @Test
            fun `1등을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.FIRST)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 로또 번호 중 한 개와 일치하면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

            @Test
            fun `2등을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.SECOND)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 일치하지 않는다면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))

            @Test
            fun `3등을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.THIRD)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 4개 일치하면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))

            @Test
            fun `4등을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.FOURTH)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 3개 일치하면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))

            @Test
            fun `5등을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.FIFTH)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 일치하는 개수가 3개 미만이면` {
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            private val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))

            @Test
            fun `꽝을 반환한다`() {
                val winningResult = winningNumber.getWinningResult(lotto)

                assertThat(winningResult).isEqualTo(WinningResult.NO_LUCK)
            }
        }
    }
}