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
    fun `입력 받은 구입 금액이 1000원 단위가 아니면 예외가 발생한다`() {

    }
    @Test
    fun `입력 받은 구입 금액이 숫자가 아니면 예외가 발생한다`() {

    }

    @Test
    fun `발행한 로또가 오름차순인지 테스트`() {

    }

    @Test
    fun `발행한 로또 번호가 6개인지 테스트`() {

    }

    @Test
    fun `로또를 알맞은 수량 발행했는지 테스트`() {

    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외가 발생한다`() {

    }

    @Test
    fun `당첨 번호가 숫자가 아니면 예외가 발생한다`() {

    }

    @Test
    fun `보너스 번호가 1개가 아니면 예외가 발생한다`() {

    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {

    }

    @Test
    fun `당첨 내역 테스트`() {

    }

    @Test
    fun `수익률 테스트`() {

    }
}
