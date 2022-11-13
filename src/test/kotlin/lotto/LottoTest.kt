package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.domain.ComputerNumber
import lotto.domain.InputValidation
import lotto.domain.Judgement
import lotto.domain.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.text.DecimalFormat


class LottoTest : NsTest() {

    private val userLottery = Lotto(listOf(2, 13, 24, 33, 34, 44))
    private val userBonusNumber = 7
    private val computerLottery: List<Lotto> = listOf(
        Lotto(listOf(2, 21, 23, 34, 42, 44)),
        Lotto(listOf(2, 7, 13, 24, 33, 44)),
        Lotto(listOf(1, 3, 5, 14, 22, 45))
    )

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Nested
    inner class `로또 구입 금액 입력값 유효성 검사`() {
        @Test
        fun `사용자가 정상적으로 입력한 경우`() {
            val inputNumber = "1000"
            val validationCheck = InputValidation(inputNumber)
            assertTrue(validationCheck.inputNumberExceptionCheck())
        }

        @Test
        fun `사용자의 입력값에 특수문자가 포함된 경우`() {
            val inputNumber = "1000;"
            val validationCheck = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                validationCheck.inputNumberExceptionCheck()
            }
        }

        @Test
        fun `사용자의 입력값이 1000으로 나누어떨어지지 않는 경우`() {
            val inputNumber = "1200"
            val validationCheck = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                validationCheck.inputNumberExceptionCheck()
            }
        }

    }

    @Nested
    inner class `사용자가 구입한 갯수만큼 로또를 출력한다`() {
        @Test
        fun case1() {
            val randomLottery = ComputerNumber(3)
            assertTrue(randomLottery.makeComputerBaseball().size == 3)
        }
    }

    @Nested
    inner class `사용자가 입력한 로또 번호 따른 에러메시지 출력`() {
        @Test
        fun `사용자가 정상적으로 입력한 경우`() {
            assertTrue(InputValidation("1,2,3,4,5,6").winningNumberExceptionCheck())
        }

        @Test
        fun `사용자의 입력값의 길이가 6이 아닌 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("1,2,3,4,5,6,7").winningNumberExceptionCheck()
            }
        }

        @Test
        fun `사용자의 입력값에 중복된 수가 있을 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("1,2,3,4,5,5").winningNumberExceptionCheck()
            }
        }

        @Test
        fun `사용자의 입력값에 쉼표(,)가 아닌 문자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("1,2,3,4,5,j").winningNumberExceptionCheck()
            }
        }

        @Test
        fun `사용자의 입력값이 1이상 45이하의 수가 아닌 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("1,2,3,4,5,46").winningNumberExceptionCheck()
            }

        }
    }

    @Nested
    inner class `사용자가 입력한 보너스 번호에 따른 에러 메시지 출력` {

        @Test
        fun `사용자가 정상적으로 입력한 경우`() {
            assertTrue(InputValidation("7").bonusNumberExceptionCheck(userLottery))
        }

        @Test
        fun `사용자의 입력값이 앞서 입력한 로또 번호와 중복될 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("2").bonusNumberExceptionCheck(userLottery)
            }
        }

        @Test
        fun `사용자의 입력값이 1이상 45이하의 수가 아닌 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("46").bonusNumberExceptionCheck(userLottery)
            }
        }

        @Test
        fun `사용자의 입력값에 문자가 포함된 경우`() {
            assertThrows<IllegalArgumentException> {
                InputValidation("44u").bonusNumberExceptionCheck(userLottery)
            }
        }

    }

    @Nested
    inner class `사용자가 입력한 로또 번호와 컴퓨터의 로또 번호를 비교한다`() {
        private val compareUserAndComputer = Judgement(computerLottery, userLottery, userBonusNumber)
        private val result: ArrayList<Int> = compareUserAndComputer.calculate()

        @Test
        fun `당첨 갯수 테스트`() {
            assertEquals(result, listOf(1, 0, 0, 1, 0))
        }

        @Test
        fun `총 수익률 계산`() {
            val decimal = DecimalFormat("#,##0.0%")
            assertEquals(compareUserAndComputer.statistics(), decimal.format(10001.6666))
        }
    }


    override fun runMain() {
        main()
    }


}
