package lotto

import lotto.domain.lotto.WinningNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class WinningNumberTest {
    @ParameterizedTest
    @MethodSource("stringProvider")
    fun `당첨 번호 콤마 5개가 아닌 경우 예외 테스트`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumber(winningNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun stringProvider(): Stream<String> {
            return Stream.of(
                "1,2,3,4,5.6",
                "1 2 3 4 5 6",
                "1,2,3,4,5,6,7",
                "1,2,3,4,6.7",
                "1,2,3,4.5 6"
            )
        }
    }
}