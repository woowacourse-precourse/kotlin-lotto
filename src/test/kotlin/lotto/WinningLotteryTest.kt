package lotto

import domain.Lotto
import domain.Rank
import domain.WinningLottery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("WinningLottery 클래스 테스트")
class WinningLotteryTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    @DisplayName("로또 번호와 보너스 번호 사이에 중복이 있으면 예외가 발생한다.")
    fun checkDuplicatedBonusBall() {
        assertThrows<IllegalArgumentException> {
            WinningLottery(winningNumbers, 1)
        }
    }

    @DisplayName("로또 번호와 보너스 번호 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun checkBonusBallRange(bonusBall: Int) {
        assertThrows<IllegalArgumentException> {
            WinningLottery(winningNumbers, bonusBall)
        }
    }

    @Test
    @DisplayName("로또 번호를 비교해 등수가 잘 나오는지 테스트한다.")
    fun checkRank() {
        val winningLottery = WinningLottery(winningNumbers, 7)
        val lottery = Lotto(winningNumbers)

        assertThat(winningLottery.getRank(lottery)).isEqualTo(Rank.FIRST_PLACE)
    }
}
