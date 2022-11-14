package lotto


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

    @Test
    fun isRightNumCountTest(){
        assertThat(util.isRightNumCount(listOf(1,2,3,4,5,6))).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isRightNumCount(listOf(1,2,3,4,5))
        }
    }

    @Test
    fun isRightRangeTest(){
        assertThat(util.isRightRange(listOf(1,2,3,4,5,6))).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.isRightRange(listOf(1,2,3,4,5,46))
        }
    }
    @Test
    fun isOverlapTest(){
        assertThat(util.isOverlap(listOf(1,2,3,4,5,6))).isEqualTo(false)
        assertThrows<IllegalArgumentException> {
            util.isOverlap(listOf(1,2,3,4,5,5))
        }
    }

    @Test
    fun checkBonusNumTest(){
        val lotto = Lotto(listOf(2,3,4,5,6,7))
        assertThat(util.checkBonusNum("1", lotto)).isEqualTo(true)
        assertThrows<IllegalArgumentException> {
            util.checkBonusNum("1,2", lotto)
            util.checkBonusNum("a", lotto)
            util.checkBonusNum("47", lotto)
        }
    }
}