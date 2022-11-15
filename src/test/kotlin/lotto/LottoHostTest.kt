package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import lotto.domain.LottoHost
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoHostTest {
    private val lottoHost = LottoHost()

    @Test
    fun `당첨번호 내 중복숫자가 있을 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwLottoException(
                    listOf(1, 2, 3, 4, 4, 6),
                    7,
                    mutableListOf(1, 2, 3, 4, 4, 6, 7)
                )
            }
        }
    }

    @Test
    fun `당첨번호가 6개가 아닌 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwLottoException(
                    listOf(1, 2, 3, 4, 5),
                    7,
                    mutableListOf(1, 2, 3, 4, 5, 7)
                )
            }
        }
    }

    @Test
    fun `당첨번호가 정해진 양식을 따르지 않을 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwWinningNumber("123456")
            }
        }
    }

    @Test
    fun `당첨번호가 1~45범위 외 일 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwLottoException(
                    listOf(1, 2, 3, 4, 5, 50),
                    7,
                    mutableListOf(1, 2, 3, 4, 5, 50, 7)
                )
            }
        }
    }

    @Test
    fun `보너스번호가 1~45범위 외 일 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwBonusNumber(
                    46
                )
            }
        }
    }


    @Test
    fun `보너스번호와 당첨번호가 중복 될 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                lottoHost.throwLottoException(
                    listOf(1, 2, 3, 4, 5, 6),
                    5,
                    mutableListOf(1, 2, 3, 4, 5, 6, 5)
                )
            }
        }
    }
}