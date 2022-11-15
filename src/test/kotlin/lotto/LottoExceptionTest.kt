package lotto

import exception.LottoException
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class LottoExceptionTest {
    @Test
    fun `로또 가격은 1000으로 나누어 떨어져야만 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoException().priceException(555)
        }
    }
    @Test
    fun `로또 당첨 번호는 크기가 6이며 요소는 1~45 사이의 숫자여야 한다`() {
        assertAll (
            Executable {
                assertThrows<IllegalArgumentException> {
                    LottoException().correctException(listOf(1,1,2,3,4,5))
                }
            },
            Executable {
                assertThrows<IllegalArgumentException> {
                    LottoException().correctException(listOf(1,2,3,4,5,6,7))
                }
            },
            Executable {
                assertThrows<IllegalArgumentException> {
                    LottoException().correctException(listOf(1,2,3,4,5,46))
                }
            }
        )
    }
    @Test
    fun `로또 보너스 번호는 당첨 번호와 겹치지 않으며 요소는 1~45 사이의 숫자여야 한다`() {
        assertAll (
            Executable {
                assertThrows<IllegalArgumentException> {
                    LottoException().bonusException(listOf(1,2,3,4,5,6), 6)
                }
            },
            Executable {
                assertThrows<IllegalArgumentException> {
                    LottoException().bonusException(listOf(1,2,3,4,5,6), 0)
                }
            }
        )
    }
}