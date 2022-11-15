package lotto.utils.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumbersSplitParserTest {
    private lateinit var parser: NumbersSplitParser

    @BeforeEach
    fun setUp() {
        parser = NumbersSplitParser()
    }

    @Test
    fun `당첨 번호를 쉼표로 구분하여 리스트로 반환해준다`() {
        val input = "1,2,3,4,5,6"
        val expected = listOf("1", "2", "3", "4", "5", "6")
        assertThat(parser.parse(input)).isEqualTo(expected)
    }
}