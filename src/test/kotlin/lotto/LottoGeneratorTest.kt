package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoGeneratorTest {

    private val lottoNumbers : List<Int>

    init {
        lottoNumbers = LottoGenerator().generate()
    }

    @Test
    fun `로또 번호가 1부터 45 사이의 숫자를 생성한다`() {
        val result = lottoNumbers.filter { number -> number <= 0 || number >= 46 }
        assertThat(result).isEmpty()
    }

    @Test
    fun `로또 번호가 오름차순으로 생성한다`() {
        assertThat(lottoNumbers).isSorted
    }
}