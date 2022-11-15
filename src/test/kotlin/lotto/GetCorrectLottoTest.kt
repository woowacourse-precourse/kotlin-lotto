package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import use_case.GetCorrectLotto

class GetCorrectLottoTest : NsTest(){

    @Test
    fun `당첨된 로또 개수가 6개가 아닌 경우 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,4,5,6,7","6") }
        }
    }
    @Test
    fun `보너스 번호가 당첨 번호에 포함될 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,4,5,6","4") }
        }
    }
    @Test
    fun `당첨 번호, 보너스 번호가 제대로 입력될 경우`() {
        assertSimpleTest {
            runException("1,2,3,4,5,6","8")
        }
    }

    override fun runMain() {
        GetCorrectLotto()
    }
}