package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class UITest : NsTest() {
    @Test
    fun `구매 금액이 1000원으로 떨어지지 않을 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `구매 금액이 0원일 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("0") }
        }
    }

    @Test
    fun `로또 번호가 범위를 벗어날 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1000","1,2,3,4,5,50") }
        }
    }

    @Test
    fun `보너스 번호가 범위를 벗어날 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1000","1,2,3,4,5,6","60") }
        }
    }

    @Test
    fun `로또 번호가 숫자가 아닐 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1000","1,2,3,4,5,as") }
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 때`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1000","1,2,3,4,5,6","hyunji") }
        }
    }

    override fun runMain() {
        main()
    }
}