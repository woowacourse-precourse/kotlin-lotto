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
    fun `로또 구매개수 테스트`() {
        val input = 8000
        val lottoNumberMaker = LottoNumberMaker()
        lottoNumberMaker.setLottoCount(input)
        assertThat(lottoNumberMaker.getLottoCount()).isEqualTo(8)
    }

    @Test
    fun `로또 정답 음수 테스트`() {
        val input = listOf("1", "2", "3", "-1", "5")
        assertThrows<IllegalArgumentException>(Constants.ERROR_MINUS_LOTTO_INPUT) {
            LottoAnswerNumberInputHandler().inputValidation(input)
        }
    }

    @Test
    fun `로또 정답 문자 테스트`() {
        val input = listOf("1", "a", "3", "-1", "5")
        assertThrows<IllegalArgumentException>(Constants.ERROR_ONLY_NUMBER) {
            LottoAnswerNumberInputHandler().inputValidation(input)
        }
    }

    @Test
    fun `로또 정답 범위 테스트`() {
        val input = listOf("1", "2", "3", "49", "5")
        assertThrows<IllegalArgumentException>(Constants.ERROR_OUT_OF_RANGE) {
            LottoAnswerNumberInputHandler().inputValidation(input)
        }
    }

    @Test
    fun `로도 정답 카운트 테스트`() {
        val answer = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(answer)
        assertThat(lotto.countCorrectNumber(listOf(1, 2, 3, 8, 9, 10), bonusNumber)).isEqualTo(3)
    }

    @Test
    fun `로도 정답 카운트 테스트2`() {
        val answer = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(answer)
        assertThat(lotto.countCorrectNumber(listOf(1, 2, 3, 4, 5, 7), bonusNumber)).isEqualTo(6)
    }

    @Test
    fun `로도 정답 카운트 테스트3`() {
        val answer = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(answer)
        assertThat(lotto.countCorrectNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber)).isEqualTo(7)
    }

    @Test
    fun `로또 상여금 계산 테스트`() {
        val input = listOf(0, 0, 0, 6, 7)
        val checker = RewardChecker(input)
        assertThat(checker.checkRank()).isEqualTo(2030000000)
    }

    @Test
    fun `수익률 계산 테스트`() {
        val reward = 10000
        val spendMoney = 5000
        val checker = EarningRateCalculator(reward, spendMoney)
        assertThat(checker.calculateEarningRate()).isEqualTo(200.0)
    }
}
