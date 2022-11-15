package lotto

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoListTest {
    private val lottoList = LottoList()

    @ParameterizedTest
    @MethodSource("parameterProvider")
    fun `getWinningResult()테스트 `(
        result: MutableList<Int>,
        value: List<Int>,
        values: List<Int>
    ) {
        Assertions.assertRandomUniqueNumbersInRangeTest({
            val winningNumber = listOf("1", "2", "3", "4", "5", "6")
            val bonus = "7"
            listOf(1, 2, 3, 4, 5, 7)
            lottoList.repeatAddition(2)
            assertThat(result).isEqualTo(lottoList.getWinningResult(winningNumber, bonus))
        }, value, values)


    }

    companion object {
        @JvmStatic
        fun parameterProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments( // 2등 1개 1등 1개 , 6개 같은 번호, 5개 같은 번호 같은 보너스 번호
                    mutableListOf(0, 0, 0, 1, 1), listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 7)
                ),
                Arguments.arguments( // 3등 1개 2등 1개 , 5개 같은 번호, 5개 같은 번호 같은 보너스 번호
                    mutableListOf(0, 0, 1, 1, 0), listOf(1, 2, 3, 4, 5, 8),
                    listOf(1, 2, 3, 4, 5, 7)
                ),
                Arguments.arguments( // 5등 1개 2등 1개, 3개 같은 번호, 5개 같은 번호 보너스 번호
                    mutableListOf(1, 0, 0, 1, 0), listOf(1, 2, 3, 13, 14, 15),
                    listOf(1, 2, 3, 4, 5, 7)
                ),
                Arguments.arguments(// 2등 1개, 5개 같은 번호 보너스 번호
                    mutableListOf(0, 0, 0, 1, 0), listOf(7, 8, 9, 10, 11, 12),
                    listOf(1, 2, 3, 4, 5, 7)
                ),
                Arguments.arguments(//3등 2개 , 5개 같은 번호, 5개 같은 번호
                    mutableListOf(0, 0, 2, 0, 0), listOf(1, 2, 3, 4, 5, 8),
                    listOf(1, 2, 3, 4, 6, 10)
                ),
                Arguments.arguments(// 꽝 , 2개 같은 번호, 1개 같은 번호
                    mutableListOf(0, 0, 0, 0, 0), listOf(1, 2, 10, 7, 8, 9),
                    listOf(1, 11, 7, 8, 9, 10)
                )
            )
        }
    }
}