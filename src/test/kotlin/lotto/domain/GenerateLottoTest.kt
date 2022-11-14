package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GenerateLottoTest {

    @Test
    fun `기능테스트(stringToList)`() {
        val str = "1,2,3,4,5,6"
        val list = listOf<Int>(1, 2, 3, 4, 5, 6)
        assertEquals(Lotto(list).list(), GenerateLotto().stringToList(str).list())
    }

    @Test
    fun `예외테스트(stringToList)`() {
        val str = "1,2,3,3,4,5"
        assertThrows<IllegalArgumentException> {
            GenerateLotto().stringToList(str)
        }

        val str2 = "1,2,3,4,5,6,7"
        assertThrows<IllegalArgumentException> {
            GenerateLotto().stringToList(str2)
        }

        val str3 = "1,2,55,4,5,48"
        assertThrows<IllegalArgumentException> {
            GenerateLotto().stringToList(str3)
        }
    }

    @Test
    fun `기능테스트(bonusNumber)`() {
        val str = "7"
        val list = listOf<Int>(1, 2, 3, 4, 5, 6)
        assertEquals(7, GenerateLotto().bonusNumber(str, Lotto(list)))
    }

    @Test
    fun `예외테스트(bonusNumber)`() {
        val str = "1"
        val list = listOf<Int>(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            GenerateLotto().bonusNumber(str, Lotto(list))
        }

        val str2 = "59"
        assertThrows<IllegalArgumentException> {
            GenerateLotto().bonusNumber(str2, Lotto(list))
        }
    }

}