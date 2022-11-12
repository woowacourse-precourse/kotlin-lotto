package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class InputConverterTest {

    @Test
    fun `문자열을 정수 한개로 변환`() {
        val input = "15"
        val result = input.toInt()
        val expected = 15
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `문자열을 ,기준으로 구분`() {
        val input = "1,2,3,4,5,6"

        val numbers = input.split(",")
        val result = numbers.map { it.toInt() }

        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertThat(result).isEqualTo(expected)
    }
}