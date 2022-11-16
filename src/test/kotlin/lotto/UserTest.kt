package lotto

import lotto.domain.Lotto
import lotto.domain.User
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private val userTest = User()

    @Test
    fun `로또 구입 금액이 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("1231a")
        }
    }

    @Test
    fun `로또 구입 금액이 int보다 큰지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("12311234123124213124")
        }
    }

    @Test
    fun `로또 구입 금액이 1000원으로 나누어 떨어지는지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkAmount("1001")
        }
    }

    @Test
    fun `로또 번호가 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkPrizeNumber("1,2,3,4,5,a")
        }
    }

    @Test
    fun `로또 번호 사이즈가 6인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkPrizeNumber("1,2,3,4,5,7,9")
        }
    }

    @Test
    fun `로또 번호가 1~45인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkPrizeNumber("1,2,3,4,5,46")
        }
    }

    @Test
    fun `로또 번호가 중복인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkPrizeNumber("1,2,3,4,5,5")
        }
    }

    @Test
    fun `보너스 번호가 숫자인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkBonusNumber("1e", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호가 1~45인지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkBonusNumber("46", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호가 겹치는지 확인한다`() {
        assertThrows<IllegalArgumentException> {
            userTest.checkBonusNumber("6", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}