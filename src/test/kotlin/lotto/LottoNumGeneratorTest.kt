package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.LottoNumGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumGeneratorTest {
    val generator = LottoNumGenerator()
    @Test
    fun makeLottoNumTest(){
        assertRandomUniqueNumbersInRangeTest(
            {
                assertThat(generator.makeLottoNum(8)).isEqualTo(
                    listOf(listOf(8, 21, 23, 41, 42, 43),
                    listOf(3, 5, 11, 16, 32, 38),
                    listOf(7, 11, 16, 35, 36, 44),
                    listOf(1, 8, 11, 31, 41, 42),
                    listOf(13, 14, 16, 38, 42, 45),
                    listOf(7, 11, 30, 40, 42, 43),
                    listOf(2, 13, 22, 32, 38, 45),
                    listOf(1, 3, 5, 14, 22, 45))
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }
}