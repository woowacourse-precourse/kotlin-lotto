package lotto.domain.model

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.WinningLottery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6),
                    LottoNumber.valueOf(7),
                )
            )
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(5),
                )
            )
        }
    }

    @Test
    fun `로또 번호가 1~45사이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber.valueOf(0),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6),
                )
            )
        }
    }

}
