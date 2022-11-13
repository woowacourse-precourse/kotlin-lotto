package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BuyerTest() {

    @Test
    fun `구입 금액 입력을 안한 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterAmount("")
        }
        assertThat(exception.message).isEqualTo(ENTER_AMOUNT)
    }

    @Test
    fun `구입 금액 입력 시 숫자가 아닌 값이 포함된 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterAmount("ab1")
        }
        assertThat(exception.message).isEqualTo(ENTER_NUMBER)
    }

    @Test
    fun `구입 금액 입력 시 1000으로 나누어 떨어지지 않는 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterAmount("9900")
        }
        assertThat(exception.message).isEqualTo(MUST_CAN_DIVIDED)
    }

    @Test
    fun `구입 금액 입력 시 Int 최대값 이상인 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterAmount("2147483648")
        }
        assertThat(exception.message).isEqualTo(WRONG_RANGE_AMOUNT)
    }

    @Test
    fun `구입 금액 입력 시 1000원 미만의 수인 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterAmount("900")
        }
        assertThat(exception.message).isEqualTo(WRONG_RANGE_AMOUNT)
    }

    @Test
    fun `당첨 번호 입력을 안 한 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("")
        }
        assertThat(exception.message).isEqualTo(ENTER_AMOUNT)
    }

    @Test
    fun `당첨 번호 입력 시 Format이 잘못된 경우 예외 발생 1_쉼표가 5개가 아닌 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("1,2,3,4,5,6,")
        }
        assertThat(exception.message).isEqualTo(FORMAT_ERROR)
    }

    @Test
    fun `당첨 번호 입력 시 Format이 잘못된 경우 예외 발생 2_숫자가 6개보다 적은 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("1,2,,,,")
        }
        assertThat(exception.message).isEqualTo(FORMAT_ERROR)

    }

    @Test
    fun `당첨 번호 입력 시 Format이 잘못된 경우 예외 발생 3_숫자와 쉼표 사이에 공백이 들어간 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("1, 2, 3, 4, 5, 6")
        }
        assertThat(exception.message).isEqualTo(FORMAT_ERROR)
    }

    @Test
    fun `당첨 번호 입력 시 Format이 잘못된 경우 예외 발생 4_숫자가 1~45 범위 안에 없는 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("1,2,4,8,80,100")
        }
        assertThat(exception.message).isEqualTo(FORMAT_ERROR)
    }

    @Test
    fun `당첨 번호 입력 시 숫자가 중복된 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterWinningNumber("1,2,4,8,8,8")
        }
        assertThat(exception.message).isEqualTo(DUPLICATE_NUMBER)
    }

    @Test
    fun `보너스 번호 입력을 안한 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterBonusNumber("")
        }
        assertThat(exception.message).isEqualTo(ENTER_AMOUNT)
    }

    @Test
    fun `보너스 번호 입력 시 1~45 범위가 안에 없는 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterBonusNumber("60")
        }
        assertThat(exception.message).isEqualTo(WRONG_RANGE_NUMBER)
    }

    @BeforeEach
    fun `중복 테스트를 위한 당첨 번호 setting`() {
        Buyer.enterWinningNumber("1,2,3,4,5,6")
    }

    @Test
    fun `보너스 번호 입력 시 당첨 번호 안에 중복값이 있는 경우 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            Buyer.enterBonusNumber("4")
        }
        assertThat(exception.message).isEqualTo(DUPLICATE_NUMBER)
    }


}