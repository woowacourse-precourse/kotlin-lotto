package lotto.domain.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

@DisplayName("당첨 로또 클래스 테스트")
internal class WinningLotteryTest {


    @Nested
    @DisplayName("생성자 테스트")
    inner class Constructor {
        @Test
        @DisplayName("보너스 번호와 로또 번호가 중첩되면 예외가 발생한다")
        fun duplicateTest() {
            assertThrows<IllegalArgumentException> {
                WinningLottery("1,2,3,4,5,6", "6")
            }
        }

        @ParameterizedTest
        @ValueSource(
            strings = ["1,2,3,4,5,a", "1,2,ㅁ,ㅇ,ㅊ,ㄷ", "1,2,3,4,5,!"]
        )
        @DisplayName("로또 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다")
        fun numberTest(winningNum: String) {
            assertThrows<IllegalArgumentException> {
                WinningLottery(winningNum, "9")
            }
        }

        @ParameterizedTest
        @ValueSource(
            strings = ["", "1,2,3", "1", "1,2,3,4,5"]
        )
        @DisplayName("로또 번호가 6자리가 아니라면 예외가 발생한다")
        fun lengthTest(winningNum: String) {
            assertThrows<IllegalArgumentException> {
                WinningLottery(winningNum, "9")
            }
        }
    }


    @Test
    fun compareLotto() {
    }
}