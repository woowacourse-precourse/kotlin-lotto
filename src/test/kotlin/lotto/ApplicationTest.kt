package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import lotto.exception.InputException
import util.Printer

class ApplicationTest : NsTest() {

    val user = User()
    val exception = InputException()
    val printer = Printer()
    val machine = Machine()

    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 62.5%입니다."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Nested
    inner class UserTest {
        @Test
        fun `구매 금액 단위 테스트`() {
            val money = "1000"
            try {
                exception.checkInputException(money)
            } catch (e: Exception) {
                Assertions.assertEquals("[ERROR] : $VALUE_EXCEPTION", e.message)
            }
        }

        @Test
        fun `구입 안내 메세지 출력`() {
            printer.printPurchaseMessage()
            assertThat(output()).isEqualTo("구입금액을 입력해 주세요.")
        }

        @Test
        fun `당첨 번호 중복 테스트`() {
            try {
                exception.checkInputNumbersException("1,2,3,4,5,5")
            } catch (e: Exception) {
                Assertions.assertEquals(true, e.message?.contains(ERROR_MESSAGE))
            }
        }

        @Test
        fun `당첨 번호 개수 테스트`() {
            try {
                exception.checkInputNumbersException("1,2,3,4,5")
            } catch (e: Exception) {
                Assertions.assertEquals(true, e.message?.contains(ERROR_MESSAGE))
            }
        }

        @Test
        fun `당첨 번호 범위 테스트`() {
            try {
                exception.checkInputNumbersException("1,2,3,4,5,60")
            } catch (e: Exception) {
                Assertions.assertEquals(true, e.message?.contains(ERROR_MESSAGE))
            }
        }
    }

    @Nested
    inner class MachineTest {

        @Test
        fun `로또 구매 개수 안내문 출력 테스트`() {
            printer.printCountLotto(5)
            assertThat(output()).isEqualTo("5개를 구매했습니다.")
        }

        @Test
        fun `로또에 입력된 수 중복 테스트`() {
            var count = 0
            for (num in 1..1000) {
                val lotto = machine.issueLottos()
                if (lotto.size != lotto.toSet().size)
                    count++
            }
            assertThat(count).isEqualTo(0)
        }
    }

    @Nested
    inner class Lotto {
        @Test
        fun `당첨된 로또 개수 테스트`() {
            val lottos = listOf(listOf(31, 32, 40, 41, 42, 45), listOf(1, 2, 3, 31, 32, 34))
            val number = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7
            val idx = Lotto(number).lottoCalculate(lottos, bonus).filterIndexed { index, it ->
                it == 1
            }.size
            assertThat(idx).isEqualTo(1)
        }

        @Test
        fun `총 수익률 검수 테스트`() {
            val money = 8000
            val prize = 5000
            val rate = machine.winningsRate(money, prize)
            assertThat(rate).isEqualTo(62.5f)
        }

    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
        const val TYPE_EXCEPTION = "올바른 형식이 아닙니다."
        const val NULL_EXCEPTION = "아무 것도 입력하지 않았습니다."
        const val VALUE_EXCEPTION = "잘못된 값입니다."
        const val OVERLAP_EXCEPTION = "중복된 값이 존재 합니다."
        const val LENGTH_EXCEPTION = "6개 입력이 아닙니다."
    }
}
