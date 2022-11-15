package lotto.domain.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class RankTest {

    @Test
    @DisplayName("정확한 Enum Class를 반환하는지 테스트한다.")
    fun valueOfTest() {
        assertSimpleTest {
            assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.CORRECT_ZERO)
            assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.CORRECT_ZERO)
            assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.CORRECT_ZERO)
            assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.CORRECT_THREE)
            assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.CORRECT_FOUR)
            assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.CORRECT_FIVE)
            assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.CORRECT_FIVE_BONUS)
            assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.CORRECT_SIX)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "7, false",
        "100, false",
        "1000, false",
    )
    @DisplayName("7이상의 숫자가 입력되면 예외를 발생한다.")
    fun valueOfExceiption(correctCnt: Int, checkBonus: Boolean) {
        assertThrows<IllegalArgumentException> {
            Rank.valueOf(correctCnt, checkBonus)
        }
    }

}