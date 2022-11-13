package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

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
    fun `입력 받은 구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1001".byteInputStream())
            getInputLottoMoney()
        }
    }

    @Test
    fun `입력 받은 구입 금액이 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1000j".byteInputStream())
            getInputLottoMoney()
        }
    }

    @Test
    fun `로또를 알맞은 수량 발행했는지 테스트`() {
        val lottos = produceLotto(8)
        assertThat(lottos).hasSize(8)
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1,2,3,4,5,6,7".byteInputStream())
            getInputWinNumbers()
        }
    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("j".byteInputStream())
            getInputWinNumbers()
        }
    }

    @Test
    fun `보너스 번호가 1개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("1,2".byteInputStream())
            getInputBonusNumber()
        }
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            System.setIn("j".byteInputStream())
            getInputBonusNumber()
        }
    }

    @Test
    fun `당첨 내역 테스트`() {
        val winRanks = calculateWinRanks(
            listOf(
                Lotto(listOf(8, 21, 23, 41, 42, 43)),
                Lotto(listOf(3, 5, 11, 16, 32, 38)),
                Lotto(listOf(7, 11, 16, 35, 36, 44)),
                Lotto(listOf(1, 8, 11, 31, 41, 42)),
                Lotto(listOf(13, 14, 16, 38, 42, 45)),
                Lotto(listOf(7, 11, 30, 40, 42, 43)),
                Lotto(listOf(2, 13, 22, 32, 38, 45)),
                Lotto(listOf(1, 3, 5, 14, 22, 45))
            ), listOf(1, 2, 3, 4, 5, 6), 7
        )
        assertThat(winRanks).isEqualTo(mapOf(LottoRank.FIFTH to 1, LottoRank.FAIL to 7))
    }

    @Test
    fun `수익률 테스트`() {
        val `yield` = calculateYield(
            mapOf(
                LottoRank.FIFTH to 1
            ), 8000
        )
        assertThat(`yield`).isEqualTo(62.5f)
    }
}
