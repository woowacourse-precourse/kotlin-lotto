package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest  : NsTest() {

    @Test
    fun `구입금액이 Int 범위를 벗어나면 에러가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateMoney("2147483648")
        }.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `구입금액에 숫자가 아닌 문자가 포함되면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateMoney("+1000")
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateMoney("ten")
        }.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `구입금액이 1000원 단위가 아니면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateMoney("1001")
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateMoney("12200")
        }.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `로또 당첨 번호가 6개가 아니면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateLotteryNumber(listOf("1", "2", "3", "4", "5"))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateLotteryNumber(listOf("1", "2", "3", "4", "5", "6", "7"))
        }.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `로또 당첨 번호에 같은 번호가 포함되어 있으면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateLotteryNumber(listOf("1", "2", "3", "4", "6", "6"))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateBonusNumber("1", listOf(1, 2, 3, 4, 5, 6))
        }.message).contains(ERROR_MESSAGE)
    }
    @Test
    fun `로또 당첨 번호가 1과 45사이의 정수가 아니면 예외가 발생한다`() {
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateLotteryNumber(listOf("0", "1", "2", "3", "4", "5"))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateLotteryNumber(listOf("1", "2", "3", "4", "5", "46"))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateBonusNumber("0", listOf(1, 2, 3, 4, 5, 6))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateBonusNumber("46", listOf(1, 2, 3, 4, 5, 6))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateBonusNumber("2147483648", listOf(1, 2, 3, 4, 5, 6))
        }.message).contains(ERROR_MESSAGE)
        assertThat(assertThrows<IllegalArgumentException> {
            Validator().validateBonusNumber("anyNumber", listOf(1, 2, 3, 4, 5, 6))
        }.message).contains(ERROR_MESSAGE)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}