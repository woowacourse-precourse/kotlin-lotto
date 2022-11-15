package lotto
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows



class AlsswlApplicationTest {
    @Test
    fun `1등`() {
        val numbers :List<Int> = listOf(1,2,3,4,5,6)
        val userNumber :List<Int> = listOf(1,2,3,4,5,6)
        val result = 1
        assertThat(checkGrade(numbers,userNumber,7)).isEqualTo(result)
    }

    @Test
    fun `2등`() {
        val numbers :List<Int> = listOf(1,2,3,4,5,7)
        val userNumber :List<Int> = listOf(1,2,3,4,5,6)
        val result = 2
        assertThat(checkGrade(numbers,userNumber,7)).isEqualTo(result)
    }

    @Test
    fun `맞는 수가 없을 때`() {
        val numbers :List<Int> = listOf(1,2,3,4,5,7)
        val userNumber :List<Int> = listOf(9,10,11,12,13,14)
        val result = 0
        assertThat(checkGrade(numbers,userNumber,7)).isEqualTo(result)
    }

    @Test
    fun `수익금 계산`() {
        val score :Array<Int> = arrayOf(0,0,0,1,0,2)
        val result = 2
        assertThat(checkEarnMoney(score)).isEqualTo(1510000.0)
    }

    @Test
    fun `보너스 맞는지 확인`() {
        val number :List<Int> = listOf(1,2,3,4,5,6)
        val bonus = 5
        assertThat(bonusSame(number, bonus)).isEqualTo(1)
    }

}