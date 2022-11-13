package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class WinningLotteryTest {

    @Test
    fun `입력 받은 당첨 번호가 숫자가 아닌 경우`() {
        val input = "1,45,k,3,l,7"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = "1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 숫자가 아닙니다. 숫자로 입력해주세요.")
    }

    @Test
    fun `당첨 번호가 총 6자리가 아닌 경우`() {
        val input = "1,21,34,12,4"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = "1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 입력하신 당첨 번호를 다시 확인해주세요. [ex. 1,2,3,4,5,6]")
    }

    @Test
    fun `당첨 번호가 중복값이 존재할 경우`() {
        val input = "1,2,2,4,32,12"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = "1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자에 중복값이 존재합니다.")
    }

    @Test
    fun `당첨 번호가 1부터 45 이내의 숫자가 아닌 경우`() {
        val input = "1,5,2,4,32,46"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = "1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자는 1부터 45 이내의 숫자만 가능합니다.")
    }

    @Test
    fun `끝에 반점이 들어갈 경우`() {
        val input = "1,5,2,4,32,"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = "1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 입력한 당점번호 끝에 반점이 있습니다.")
    }

    @Test
    fun `보너스 번호 유효한 숫자가 아닌 경우1`() {
        val input = "1,2,3,4,5,6"
        val bonus = "46"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자는 1부터 45 이내의 숫자만 가능합니다.")
    }

    @Test
    fun `보너스 번호가 유효한 숫자가 아닌 경우2`() {
        val input = "1,2,3,4,5,6"
        val bonus = "121"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자는 1부터 45 이내의 숫자만 가능합니다.")
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 문자가 들어온 경우`() {
        val input = "1,2,3,4,5,6"
        val bonus = "k"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 숫자가 아닙니다. 숫자로 입력해주세요.")
    }
}
