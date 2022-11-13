package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest(){
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }



    // 아래에 추가 테스트 작성 가능

    /** 유저가 입력하는 로또 투입금액 에러 테스트 **/
    @Test
    fun `사용자 입력 값에 아무것도 입력되지 않을 경우 예외가 발생한다`() {
        assertSimpleTest {
            UserInputPrice("").checkUserInputPriceRegexAndTranslateToInt()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 입력 값에 문자열이 포함될 경우 예외가 발생한다`() {
        assertSimpleTest {
            UserInputPrice("10r00").checkUserInputPriceRegexAndTranslateToInt()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 입력 값이 로또 가격으로 나누어 떨어지지 않을 경우 예외가 발생한다`() {
        assertSimpleTest {
            UserInputPrice("1200").checkUserInputPriceRegexAndTranslateToInt()
            Assertions.assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
