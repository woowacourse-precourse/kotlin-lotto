package lotto

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    private val exception = Exception()

    @Test
    fun `로또 번호 입력 형식이 틀렸을 경우 예외를 던짐`() {
        val input = "1,2,3,34,,5,7"
        assertThrows<IllegalArgumentException>{
            exception.throwException(input)
        }
    }

    @Test
    fun `입력한 것들 중 중복된 숫자가 있는 경우 예외를 던짐`() {
        val input = "1,2,3,5,5,7"
        assertThrows<IllegalArgumentException>{
            exception.throwException(input)
        }
    }

    @Test
    fun `숫자를 7개 이상 입력했다면 예외를 던짐`() {
        val input = "1,2,3,5,6,7,4"
        assertThrows<IllegalArgumentException>{
            exception.throwException(input)
        }    }

    @Test
    fun `1 ~ 45 이외의 숫자가 있으면 예외를 던짐`() {
        val input = "1,45,23,37,5,90"
        assertThrows<IllegalArgumentException>{
            exception.throwException(input)
        }    }
}