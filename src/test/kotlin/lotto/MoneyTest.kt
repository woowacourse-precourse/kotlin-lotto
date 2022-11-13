package lotto

import lotto.domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `금액이 음수인 경우`() {
        val money = "-1000"
        assertThrows<IllegalArgumentException> { Money(money) }
    }

    @Test
    fun `금액이 숫자가 아닌 경우 테스트`() {
        val money = "100a"
        assertThrows<IllegalArgumentException> { Money(money) }
    }

    @Test
    fun `금액이 1000원 단위가 아닌 경우 테스트`() {
        val money = "1100"
        assertThrows<IllegalArgumentException> { Money(money) }
    }

    @Test
    fun `돈 단위 변경 테스트`() {
        val money = "2000000000"
        val result = Money(money).changeMoneyUnit()
        assertThat(result).isEqualTo("2,000,000,000")
    }
}