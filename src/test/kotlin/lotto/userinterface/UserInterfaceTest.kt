package lotto.userinterface

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.userinterface.UserInterface.askPurchaseAmount
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `UserInterface 클래스의` {
    @Nested
    inner class `askPurchaseAmount 메소드는`: NsTest() {
        @Nested
        inner class `사용자가 콘솔에 숫자가 아닌 값을 입력하면` {
            private val purchaseAmount = "1000j"
            @Test
            fun `예외를 던지고 에러 메시지를 출력한다`() {
                assertThatThrownBy { runException(purchaseAmount) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining(ERROR_MESSAGE)
            }
        }

        override fun runMain() {
            askPurchaseAmount()
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}