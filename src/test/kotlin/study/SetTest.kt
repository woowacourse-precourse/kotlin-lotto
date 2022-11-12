package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class SetTest {
    private var numbers = mutableSetOf<Int>()

    @BeforeEach
    fun setUp() {
        numbers.add(1)
        numbers.add(1)
        numbers.add(2)
        numbers.add(3)
    }

    @Test
    fun `size 메서드로 set의 크기 확인`() {
        assertThat(numbers.size).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `contains 메서드로 값 존재 여부 확인`(num: Int) {
        assertThat(numbers.contains(num)).isTrue
    }

    @ParameterizedTest
    @CsvSource("1,true", "2,true", "3,true", "4,false", "5,false")
    fun `contains 메서드로 값 존재 여부 확인 2`(num: Int, result: Boolean) {
        assertThat(numbers.contains(num)).isEqualTo(result)
    }
}