package lotto.domain.model

import lotto.utils.Constants.BONUS_NOT_DUPLICATE_TEXT
import lotto.utils.Constants.LOTTO_LENGTH_MUST_SIX_TEXT
import lotto.utils.Constants.LOTTO_NUM_MUST_NUMBER_TEXT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

@DisplayName("당첨 로또 클래스 테스트")
internal class WinningLotteryTest {

    private lateinit var winningLottery: WinningLottery

    @BeforeEach
    fun setUp() {
        winningLottery = WinningLottery("1,2,3,4,5,6", "7")
    }

    @Nested
    @DisplayName("생성자 테스트")
    inner class Constructor {
        @Test
        @DisplayName("보너스 번호와 로또 번호가 중첩되면 예외가 발생한다")
        fun duplicateTest() {
            val thrown = assertThrows<IllegalArgumentException> {
                WinningLottery("1,2,3,4,5,6", "6")
            }
            assertThat(thrown.message).contains(BONUS_NOT_DUPLICATE_TEXT)
        }

        @ParameterizedTest
        @ValueSource(
            strings = ["", "1,2,3,4,5,a", "1,2,ㅁ,ㅇ,ㅊ,ㄷ", "1,2,3,4,5,!"]
        )
        @DisplayName("로또 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다")
        fun numberTest(winningNum: String) {
            val thrown = assertThrows<IllegalArgumentException> {
                WinningLottery(winningNum, "9")
            }
            assertThat(thrown.message).contains(LOTTO_NUM_MUST_NUMBER_TEXT)
        }

        @ParameterizedTest
        @ValueSource(
            strings = ["1,2,3", "1", "1,2,3,4,5"]
        )
        @DisplayName("로또 번호가 6자리가 아니라면 예외가 발생한다")
        fun lengthTest(winningNum: String) {
            val thrown = assertThrows<IllegalArgumentException> {
                WinningLottery(winningNum, "9")
            }
            assertThat(thrown.message).contains(LOTTO_LENGTH_MUST_SIX_TEXT)
        }
    }


    @Nested
    @DisplayName("로또 비교 테스트")
    inner class CompareTest {
        @Test
        @DisplayName("1등, 2등, 2등+보너스 결과 값을 반환하는지 체크")
        fun compareLotto1() {
            assertThat(winningLottery.compareLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.CORRECT_SIX)
            assertThat(winningLottery.compareLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.CORRECT_FIVE_BONUS)
            assertThat(winningLottery.compareLotto(Lotto(listOf(1, 2, 3, 4, 5, 10)))).isEqualTo(Rank.CORRECT_FIVE)
        }

        @Test
        @DisplayName("3등, 4등 꼴등 결과 값을 반환하는지 체크")
        fun compareLotto2() {
            assertThat(winningLottery.compareLotto(Lotto(listOf(1, 2, 3, 10, 11, 12)))).isEqualTo(Rank.CORRECT_THREE)
            assertThat(winningLottery.compareLotto(Lotto(listOf(1, 2, 3, 4, 10, 11)))).isEqualTo(Rank.CORRECT_FOUR)
        }
    }

}