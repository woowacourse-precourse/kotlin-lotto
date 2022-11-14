package lotto.userinterface

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.userinterface.UserInterface.askBonusNumberNotIn
import lotto.userinterface.UserInterface.askPurchaseAmount
import lotto.userinterface.UserInterface.askWinningNumbers
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream

internal class UserInterfaceTest {
    @Nested
    inner class `askPurchaseAmount 메소드는` : NsTest() {
        @Nested
        inner class `실행하면` {
            private val purchaseAmount = "1000"

            @Test
            fun `구입 금액 입력을 요청하는 메시지를 출력한다`() {
                run(purchaseAmount)

                assertThat(output()).isEqualTo(REQUEST_PURCHASE_AMOUNT)
            }
        }

        @Nested
        inner class `사용자가 콘솔에 숫자가 아닌 값을 입력하면` {
            private val purchaseAmount = "1000j"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(purchaseAmount) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `사용자가 콘솔에 20억 보다 큰 숫자를 입력하면` {
            private val purchaseAmount = "2000000001"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(purchaseAmount) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `사용자가 콘솔에 1000으로 나누어 떨어지지 않는 숫자를 입력하면` {
            private val purchaseAmount = "1300"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(purchaseAmount) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `사용자가 제한을 넘지 않는 1000으로 나누어 떨어지는 숫자를 입력하면` {
            private val purchaseAmount = "2000000000"

            @Test
            fun `로또 구입 금액을 반환한다`() {
                System.setIn(ByteArrayInputStream(purchaseAmount.toByteArray()))

                val result = askPurchaseAmount()

                assertThat(result).isEqualTo(purchaseAmount.toInt())
            }
        }

        override fun runMain() {
            askPurchaseAmount()
        }
    }

    @Nested
    inner class `askWinningNumbers 메소드는` : NsTest() {
        @Nested
        inner class `실행하면` {
            private val winningNumbers = "1,2,3,4,5,6"

            @Test
            fun `당첨 번호 입력 요청 메시지를 출력한다`() {
                run(winningNumbers)

                assertThat(output()).isEqualTo(REQUEST_WINNING_NUMBERS)
            }
        }

        @Nested
        inner class `당첨 번호가 6개가 아니면` {
            private val winningNumbers = "1,2,3,4,5"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(winningNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `당첨 번호가 1에서 45 사이의 숫자가 아니면` {
            private fun winningNumbers() = listOf(
                Arguments.of("1,2,3,4,5,0"),
                Arguments.of("1,2,3,4,5,a")
            )

            @ParameterizedTest
            @MethodSource("winningNumbers")
            fun `예외를 던지고 에러 메시지를 출력한다`(winningNumbers: String) {
                assertThatThrownBy { runException(winningNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `당첨 번호가 중복되었다면` {
            private val winningNumbers = "1,2,3,4,5,5"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(winningNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `1에서 45 사이의 서로 다른 6개의 숫자로 이루어진 번호를 입력하면` {
            private val winningNumbers = "1,2,3,4,5,6"

            @Test
            fun `당첨 번호를 반환한다`() {
                System.setIn(ByteArrayInputStream(winningNumbers.toByteArray()))

                val result = askWinningNumbers()

                assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
            }
        }

        @Nested
        inner class `당첨 번호를 입력할 때 공백이 포함되어도` {
            private val winningNumbers = "1, 2, 3, 4, 5, 6"

            @Test
            fun `당첨 번호를 반환한다`() {
                System.setIn(ByteArrayInputStream(winningNumbers.toByteArray()))

                val result = askWinningNumbers()

                assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
            }
        }

        override fun runMain() {
            askWinningNumbers()
        }
    }

    @Nested
    inner class `askBonusNumberNotIn 메소드는` : NsTest() {
        private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        @Nested
        inner class `실행하면` {
            private val bonusNumber = "7"

            @Test
            fun `보너스 번호 입력 요청 메시지를 출력한다`() {
                run(bonusNumber)

                assertThat(output()).isEqualTo(REQUEST_BONUS_NUMBER)
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `사용자가 1에서 45 사이의 숫자가 아닌 값을 입력하면` {
            private fun bonusNumber() = listOf(
                Arguments.of("0"),
                Arguments.of("a")
            )

            @ParameterizedTest
            @MethodSource("bonusNumber")
            fun `예외를 던지고 에러 메시지를 출력한다`(bonusNumber: String) {
                assertThatThrownBy { runException(bonusNumber) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `사용자가 당첨 번호에 포함되는 숫자를 입력하면` {
            private val bonusNumber = "1"

            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(bonusNumber) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `사용자가 당첨 번호를 입력하면` {
            private val bonusNumber = "7"

            @Test
            fun `당첨 번호를 반환한다`() {
                System.setIn(ByteArrayInputStream(bonusNumber.toByteArray()))

                val result = askBonusNumberNotIn(winningNumbers)

                assertThat(result).isEqualTo(bonusNumber.toInt())
            }
        }

        override fun runMain() {
            askBonusNumberNotIn(winningNumbers)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}