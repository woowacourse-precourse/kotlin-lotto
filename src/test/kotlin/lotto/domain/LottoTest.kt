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

    @Nested
    inner class `rankWhenWinningNumberIs 메소드는` {
        @Nested
        inner class `당첨 번호와 로또 번호가 모두 일치하면` {
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

            @Test
            fun `1등을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.FIRST)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 일치하면` {
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
            
            @Test
            fun `2등을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.SECOND)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 일치하지 않는다면` {
            private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

            @Test
            fun `3등을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.THIRD)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 4개 일치하면` {
            private val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

            @Test
            fun `4등을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.FOURTH)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 3개 일치하면` {
            private val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

            @Test
            fun `5등을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.FIFTH)
            }
        }

        @Nested
        inner class `당첨 번호와 로또 번호가 일치하는 개수가 3개 미만이면` {
            private val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
            private val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)

            @Test
            fun `꽝을 반환한다`() {
                val rank = lotto.rankWhenWinningNumberIs(winningNumber)

                assertThat(rank).isEqualTo(Rank.NO_LUCK)
            }
        }
    }
}
