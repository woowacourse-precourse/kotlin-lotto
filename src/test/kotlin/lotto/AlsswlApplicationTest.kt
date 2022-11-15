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

}