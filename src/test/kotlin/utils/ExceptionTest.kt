package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.ExceptionHandler

class ExceptionTest {

    @Test
    fun `로또 번호 입력 형식이 틀렸을 경우 false 를 반환`() {
        val inputSymbol = "d"
        assertThat(ExceptionHandler.getIsInputFormRight(inputSymbol)).isFalse
    }

    @Test
    fun `입력한 것들 중 중복된 숫자가 있는 경우 false 를 반환`() {
        val lottoNumbers = listOf(1, 2, 2, 3, 4, 5)
        assertThat(ExceptionHandler.getHasDistinctNumber(lottoNumbers)).isFalse
    }

    @Test
    fun `입력한 로또 번호가 6개가 아닐 경우 false 를 반환`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)
        assertThat(ExceptionHandler.getIsSizeSix(lottoNumbers)).isFalse
    }

    @Test
    fun `보너스 번호가 1과 45 사이가 아니라면 false 를 반환`() {
        val bonusNumber = 46
        assertThat(ExceptionHandler.getIsBetweenOneAndFortyFive(bonusNumber)).isFalse
    }

    @Test
    fun `보너스 번호가 입력한 6개의 로또 번호와 중복된다면 false 를 반환`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5,45)
        val bonusNumber = 3
        assertThat(ExceptionHandler.getHasDistinctNumberInLottoNumbers(bonusNumber, lottoNumbers)).isFalse
    }

    @Test
    fun `구입 금액이 1000원 단위가 아니라면 false 를 반환`() {
        val purchaseMoney = 4500
        assertThat(ExceptionHandler.getIsThousandUnit(purchaseMoney)).isFalse
    }

    @Test
    fun `구입 금액이 0보다 작으면 false 를 반환`() {
        val purchaseMoney = -4500
        assertThat(ExceptionHandler.getIsPositiveNumber(purchaseMoney)).isFalse
    }

}