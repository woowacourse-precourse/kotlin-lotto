package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class NumberGeneratorTest {

    @Test
    fun `기능 테스트`() {
        val numberGenerator = NumberGenerator()
        val randomNumbers = numberGenerator.createRandomNumbers()
        print(randomNumbers.toString())
        Assertions.assertThat(
            randomNumbers.size == 6 &&
            randomNumbers.toSet().size == 6 &&
            randomNumbers.filter { it in 1..45 }.size == 6
        )
    }

    @Test
    fun `정렬 테스트`() {
        val numberGenerator = NumberGenerator()
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                val getElement = numberGenerator.createRandomNumbers()
                Assertions.assertThat(getElement).isEqualTo(
                    listOf(8, 21, 23, 41, 42, 43)
                )
            },
            listOf(43, 41, 21, 8, 42, 23)
        )
    }
}
