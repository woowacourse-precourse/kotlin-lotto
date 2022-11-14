package lotto

import lotto.Util
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilTest {
    val util = Util()
    @Test
    fun isNumIntTest(){
        assertThat(util.isNumInt("1000")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isNumInt("abcd")
        }
    }

    @Test
    fun isRightFormTest(){
        assertThat(util.isRightForm("1,2,3,4,5,6")).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isRightForm("123,456")
        }
    }

    @Test
    fun changeInputToLottoTest(){
        assertThat(util.changeInputToLotto("1,2,3,4,5,6")).isEqualTo(listOf(1,2,3,4,5,6))
    }

//    @Test
//    fun isRightNumCountTest(){
//        assertThat(isRightNumCOunt(1,2,3,4,5,6)).isEqualTo(true)
//        assertThrows<IllegalArgumentException> {
//            isRightNumCOunt(1,2,3,4,5)
//        }
//    }
//
//    @Test
//    fun isRightRangeTest(){
//        assertThat(isRightNumCOunt(1,2,3,4,5,6)).isEqualTo(true)
//        assertThrows<IllegalArgumentException> {
//            isRightNumCOunt(1,2,3,4,5,46)
//        }
//    }
//    @Test
//    fun isOverlapTest(){
//        assertThat(isOverlap(1,2,3,4,5,6)).isEqualTo(false)
//        assertThrows<IllegalArgumentException> {
//            isOverlap(1,2,3,4,5,5)
//        }
//    }
//
//    @Test
//    fun checkBonusNumTest(){
//        assertThat(checkBonusNum("1")).isEqualTo(true)
//        assertThrows<IllegalArgumentException> {
//            checkBonusNum("1,2")
//            checkBonusNum("a")
//            checkBonusNum("47")
//        }
//    }
}