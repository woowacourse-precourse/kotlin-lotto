package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilsTest {
    @Test
    fun `splitToIntList 잘 작동한다`() {
        assertThat("1,2,3,4,5".splitToIntList() == listOf(1, 2, 3, 4, 5))
        assertThat("1".splitToIntList() == listOf(1))
    }

    @Test
    fun `숫자가 아니면 에러발생`() {
        assertThrows<IllegalArgumentException> {
            "1,2,3,4,a".splitToIntList()
        }
    }

    @Test
    fun `checkNull 정상 작동 확인`() {
        assertThat("0".toIntOrError())
    }
}
