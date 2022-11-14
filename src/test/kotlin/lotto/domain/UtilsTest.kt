package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilsTest {
    @Test
    fun `splitToIntList 기능 테스트`() {
        assertThat("1,2,3,4,5".splitToIntList() == listOf(1, 2, 3, 4, 5))
        assertThat("1".splitToIntList() == listOf(1))
    }

    @Test
    fun `splitToIntList separator 이외에 숫자가 없으면 에러를 발생`() {
        assertThrows<IllegalArgumentException> {
            "1,2,3,4,a".splitToIntList()
        }
    }

    @Test
    fun `checkNull 기능 테스트`() {
        assertThat("0".toIntOrError())
    }

    @Test
    fun `checkNull 에러 테스트`() {
        assertThrows<IllegalArgumentException> { null.toIntOrError() }
    }
}
