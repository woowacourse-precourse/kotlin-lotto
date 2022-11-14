package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CacherTest {
    private val cacher = Cacher()

    @Test
    fun `금액입력 형식 확인`() {
        assertThat(cacher.enterPurchaseMoney("123000")).isEqualTo(123000)
    }

    @Test
    fun `금액입력이 숫자가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            cacher.enterPurchaseMoney("123가나")
        }
    }

    @Test
    fun `금액입력이 자연수가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            cacher.enterPurchaseMoney("-12345")
        }
    }

    @Test
    fun `금액입력이 천원 단위로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            cacher.enterPurchaseMoney("12300")
        }
    }

    @Test
    fun `로또의 개수를 계산한다`() {
        assertThat(cacher.calculateNumberOfLottos(23000)).isEqualTo(23)
    }
}
