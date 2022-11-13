package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능

    @Nested
    inner class TicketingMachineTest {
        private val ticketingMachine = TicketingMachine()

        @Test
        fun `개수만큼 로또 발행`() {
            val result = ticketingMachine.createLottoNumbers(5)
            assertThat(result).hasSize(5)
        }
    }

    @Nested
    inner class CacherTest {
        private val cacher = Cacher()

        @Test
        fun `금액입력 형식 확인`() {
            assertThat(cacher.enterPurchaseMoney("")).isEqualTo(123000)
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
}
