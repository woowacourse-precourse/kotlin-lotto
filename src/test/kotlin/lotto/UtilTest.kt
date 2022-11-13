package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilTest {
    @Test
    fun isNumIntTest(){
        assertThat(isNumInt("1000")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            isNumInt("abcd")
        }
    }

    @Test
    fun isRightFormTest(){
        assertThat(isRightForm("1,2,3,4,5,6")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            isRightForm("123,456")
        }
    }

    @Test
    fun isRightNumCountTest(){
        assertThat(isRightNumCOunt("1,2,3,4,5,6")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            isRightNumCOunt("1,2,3,4,5")
        }
    }

    @Test
    fun isRightNumCountTest(){
        assertThat(isRightNumCOunt("1,2,3,4,5,6")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            isRightNumCOunt("1,2,3,4,5")
        }
    }
}