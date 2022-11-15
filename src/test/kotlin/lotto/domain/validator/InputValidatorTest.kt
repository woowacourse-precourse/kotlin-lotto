package lotto.domain.validator

import lotto.domain.common.ErrorType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidatorTest {

    // 티켓 구매 금액
    @Test
    fun `티켓 구매 금액이 숫자가 아니면 에러 반환`() {
        assertThat(InputValidator.validateTicketMoney("abc")).isEqualTo(ErrorType.MONEY)
    }

    @Test
    fun `티켓 구매 금액이 1000원 단위가 아니면 에러 반환`() {
        assertThat(InputValidator.validateTicketMoney("1400")).isEqualTo(ErrorType.MONEY)
    }

    @Test
    fun `티켓 구매 금액이 0원이면 에러 반환`() {
        assertThat(InputValidator.validateTicketMoney("0")).isEqualTo(ErrorType.MONEY)
    }

    // 당첨 번호 6개
    @Test
    fun `당첨 번호 입력이 6개가 아니면 에러 반환`() {
        assertThat(InputValidator.validateWinningLottoNumbers("1,2,3,4,5")).isEqualTo(ErrorType.COUNT)
    }

    @Test
    fun `당첨 번호 입력에 숫자가 아닌 문자가 있으면 에러 반환`() {
        assertThat(InputValidator.validateWinningLottoNumbers("1,2,a,4,5,6")).isEqualTo(ErrorType.RANGE)
    }

    @Test
    fun `당첨 번호 입력에 1-45 범위가 넘는 숫자가 있으면 에러 반환`() {
        assertThat(InputValidator.validateWinningLottoNumbers("1,8,30,40,44,80")).isEqualTo(ErrorType.RANGE)
    }

    @Test
    fun `당첨 번호 입력에 중복이 있으면 에러 반환`() {
        assertThat(InputValidator.validateWinningLottoNumbers("1,2,2,4,5,6")).isEqualTo(ErrorType.DUPLICATION)
    }

    // 보너스 번호
    @Test
    fun `보너스 번호가 숫자가 아닌 문자면 에러 반환`() {
        assertThat(InputValidator.validateBonusLottoNumber(listOf(1,2,3,4,5,6),"abc")).isEqualTo(ErrorType.RANGE)
    }

    @Test
    fun `보너스 번호가 1-45 범위가 넘는 숫자이면 에러 반환`() {
        assertThat(InputValidator.validateBonusLottoNumber(listOf(1,2,3,4,5,6),"47")).isEqualTo(ErrorType.RANGE)
    }

    @Test
    fun `보너스 번호가 당첨 번호 6개와 중복되는 숫자이면 에러 반환`() {
        assertThat(InputValidator.validateBonusLottoNumber(listOf(1,2,3,4,5,6),"3")).isEqualTo(ErrorType.DUPLICATION)
    }
}