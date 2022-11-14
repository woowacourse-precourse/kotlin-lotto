package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest : NsTest() {
    @Test
    fun `로또 구입 금액 입력 테스트 1, 1000원으로 나누어 떨어지지 않는 값`() {
        assertSimpleTest {
            runException("7500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 구입 금액 입력 테스트 2, 정수가 아닌 값`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 구입 금액 입력 테스트 3, 0 이하인 값`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `로또 구입 금액 입력 테스트 4, 정상 입력`() {
        assertSimpleTest {
            runException("5000")
            assertThat(output()).doesNotContain(ERROR_MESSAGE)
        }
    }

    @Test
    fun `랜덤 로또 번호 출력 테스트 1, 구입한 금액만큼의 로또를 구입하지 않음`() {
        assertSimpleTest {
            isWrongLottoTicketCount(8, emptyList())
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `랜덤 로또 번호 출력 테스트 2, 구입한 로또의 번호 개수가 중복을 제외하고 6개가 아님`() {
        assertThrows<IllegalArgumentException> {
            isWrongCurrentLottoNumbers(Lotto(listOf(1,1,3,4,5,6)))
        }
    }

    @Test
    fun `랜덤 로또 번호 출력 테스트 3, 구입한 로또의 번호가 1과 45사이에 있지 않음`() {
        assertThrows<IllegalArgumentException> {
            isWrongCurrentLottoNumbers(Lotto(listOf(45,46,3,4,5,6)))
        }
    }

    @Test
    fun `랜덤 로또 번호 출력 테스트 4, 정상적인 랜덤 로또 번호`() {
        assertSimpleTest {
            val isWrong = isWrongCurrentLottoNumbers(Lotto(listOf(1,2,3,4,5,6)))
            assertThat(isWrong).isEqualTo(false)
        }
    }

    @Test
    fun `당첨 번호 출력 테스트 1, 6개 번호 입력시 입력값에 정수가 아닌 값이 들어있음`() {
        assertSimpleTest {
            isWrongWinningNumbers(listOf("1", "2", "3", "4", "5", "aaaa",))
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `당첨 번호 출력 테스트 2, 6개 번호 입력 중 1과 45 사이 아닌 정수가 있음`() {
        assertSimpleTest {
            isWrongWinningNumbers(listOf("1", "2", "3", "4", "5", "0",))
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호 출력 테스트 3, 당첨번호 6개와 보너스 번호 1개를 합쳐서 중복을 제외한 숫자들의 개수가 7개가 아님`() {
        assertSimpleTest {
            isWrongWinningLotto(listOf("1", "2", "3", "4", "5", "0", "1"))
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `당첨 번호 출력 테스트 4, 정상적인 당첨번호 리스트`() {
        assertSimpleTest {
            val isWrong = isWrongWinningLotto(listOf("1", "2", "3", "4", "5", "6", "7"))
            assertThat(isWrong).isEqualTo(false)
        }
    }
    
    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}