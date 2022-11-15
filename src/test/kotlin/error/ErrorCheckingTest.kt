package error

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import domain.Lotto
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorCheckingTest {
    @Test
    fun `로또 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkNumOfLotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호가 범위 밖이면 예외가 발생한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                LottoError.checkOutOfRange(0)
            }
            assertThrows<IllegalArgumentException> {
                LottoError.checkOutOfRange(listOf(1, 2, 3, 4, 5, 50))
            }
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkDuplicate(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `보너스 숫자가 이미 당첨번호에 존재하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoError.checkDuplicate(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `숫자가 아닌 값이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputError.checkInteger("a")
        }
    }

    @Test
    fun `숫자가 음수면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputError.checkNegative(-1)
        }
    }

    @Test
    fun `금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputError.checkMoneyDivided(1450)
        }
    }

    @Test
    fun `금액이 0인 경우 예외가 발생한다`() {
         assertThrows<IllegalArgumentException> {
             InputError.checkMoneyZero(0)
         }
    }

    @Nested
    inner class `당첨번호 입력 형식에 맞지 않는 경우 오류 테스트` {
        @Test
        fun case1() {
            assertThrows<IllegalArgumentException> {
                InputError.checkWinningsFormat("3. 5, 4. 6, 8")
            }
        }
        @Test
        fun case2() {
            assertThrows<IllegalArgumentException> {
                InputError.checkWinningsFormat("4, a, 6, 7, 8")
            }
        }
        @Test
        fun case3() {
            assertThrows<IllegalArgumentException> {
                InputError.checkWinningsFormat("1, 2, 3, 4, , 6")
            }
        }
    }
}