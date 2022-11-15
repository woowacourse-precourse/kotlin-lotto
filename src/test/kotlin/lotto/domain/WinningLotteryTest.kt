package lotto.domain

import lotto.utils.Validator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class WinningLotteryTest {

    @Test
    @DisplayName("입력 받은 당첨 번호가 숫자가 아닌 경우")
    fun `당첨번호_문자일때_예외발생`() {
        val input = "1,45,k,3,l,7"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = 1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 유효한 숫자가 아닙니다.")
    }

    @Test
    @DisplayName("당첨 번호가 총 6자리가 아닌 경우")
    fun `당첨번호_6자리가_아닐때_예외발생`() {
        val input = "1,21,34,12,4"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = 1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 입력하신 당첨 번호를 다시 확인해주세요. [ex. 1,2,3,4,5,6]")
    }

    @Test
    @DisplayName("당첨 번호가 중복값이 존재할 경우")
    fun `당첨번호_중복값_존재시_예외발생`() {
        val input = "1,2,2,4,32,12"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = 1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자에 중복값이 존재합니다.")
    }

    @Test
    @DisplayName("당첨 번호가 1부터 45 이내의 숫자가 아닌 경우")
    fun `당첨번호_1_부터_45_이내가_아닐경우_예외발생`() {
        val input = "1,5,2,4,32,46"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = 1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자는 1부터 45 이내의 숫자만 가능합니다.")
    }

    @Test
    @DisplayName("당첨번호 입력값 맨 끝에 반점이 존재했을 때 split 메서드 사용 시 last index 에 null 값이 들어옴")
    fun `당첨번호_끝에_반점이_있을경우_예외발생`() {
        val input = "1,5,2,4,32,"

        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus = 1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 입력한 당점번호 끝에 반점이 있습니다.")
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 중복이 되는 경우는 없다. 따라서 예외테스트")
    fun `보너스번호_와_당첨번호_중복일시_예외발생`() {
        val input = "1,2,3,4,5,6"
        val bonus = 1
        Assertions.assertThatThrownBy {
            val winningLottery = WinningLottery(input, bonus)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 복권 숫자에 중복값이 존재합니다.")
    }

    @ParameterizedTest
    @CsvSource(
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
        "41", "42", "43", "44", "45"
    )
    @DisplayName("보너스 번호를 입력 받을 시, 1~45 내의 숫자인지 여부 파악")
    fun `보너스번호_유효성_확인`(input: String) {
        val bonus = Validator.checkBonusNumber(input)
        Assertions.assertThat(input.toInt()).isEqualTo(bonus)
    }

    @ParameterizedTest
    @CsvSource(
        "51", "52", "53", "54", "55", "56", "57", "58", "59", "0",
        "2a1", "2d2", "423", "294", "225", "269", "*27", "2qq8", "2d9", "00",
        "100000000000000046", "47", "48", "49", "50"
    )
    @DisplayName("보너스 번호를 입력 받을 시, 올바른 값이 아닐 경우 예외처리 (문자, 특수문자, 0, 46이상의 수)")
    fun `보너스번호_유효성_실패시_예외발생`(input: String) {
        Assertions.assertThatThrownBy {
            val bonus = Validator.checkBonusNumber(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 유효한 숫자가 아닙니다.")
    }
}
