package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

internal class GetPriceTest {

    @Test
    fun `가격입력기능테스트`() {
        val str = "1000"
        assertEquals(1000, GetPrice().getNum(str))
    }

    @Test
    fun `가격입력예외테스트`() {
        assertThrows<NoSuchElementException> {
            GetPrice().getNum("0")
        }
    }
}