package lotto

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

    @Test
    fun `구매액은 숫자여야한다`() {
        assertThrows<IllegalArgumentException> {
            LottoErrorCheck.checkinputisnumber("100a")
        }

    }

    @Test
    fun `로또 구매액은 1000이상`() {
        assertThrows<IllegalArgumentException> {
            LottoErrorCheck.checkleastvalue(999)
        }

    }

    @Test
    fun `로또 구매액은 1000으로 떨어지게`() {
        assertThrows<IllegalArgumentException> {
            LottoErrorCheck.checkitdoesnothavechange(1970)
        }

    }

    @Test
    fun `로또는 항상 1~45사이`() {
        assertThrows<IllegalArgumentException> {
            LottoErrorCheck.checknumberisinlottorange(46)
        }

    }

    @Test
    fun `당첨번호와 보너스볼은 중복 안됨`() {
        assertThrows<IllegalArgumentException> {
            LottoErrorCheck.bonusballcheck(listOf(1, 2, 3, 4, 5, 6), 1)
        }
    }
}
