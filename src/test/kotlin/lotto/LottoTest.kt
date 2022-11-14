package lotto

import org.assertj.core.api.Assertions.assertThat
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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `음수 입력 테스트`() {
         assertThrows<IllegalArgumentException>(Constants.ERROR_MINUS_INPUT) {
            MoneyInputHandler().inputValidation("-0")
        }
    }

    @Test
    fun `1000원 이하 입력 테스트`() {
        assertThrows<IllegalArgumentException>(Constants.ERROR_UNDER_MINIMUM) {
            MoneyInputHandler().inputValidation("900")
        }
    }

    @Test
    fun `문자 포함 테스트`() {
        assertThrows<IllegalArgumentException>(Constants.ERROR_ONLY_NUMBER) {
            MoneyInputHandler().inputValidation("1000j")
        }
    }

    @Test
    fun `1000으로 나눠지는지 테스트`() {
        assertThrows<IllegalArgumentException>(Constants.ERROR_DIVIDE_UNIT) {
            MoneyInputHandler().inputValidation("1999")
        }
    }

    @Test
    fun `로또 구매개수 테스트`(){
        val input = 8000
        val lottoNumberMaker = LottoNumberMaker()
        lottoNumberMaker.setLottoCount(input)
        assertThat(lottoNumberMaker.getLottoCount()).isEqualTo(8)
    }

}
