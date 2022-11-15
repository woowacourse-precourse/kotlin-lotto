package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import use_case.BuyLotto
import java.io.InputStream

class BuyLottoTest: NsTest() {
    @Test
    fun `입력받은 가격이 1~45 사이의 정수가 아닌 경우 에러 발생`() {
        System.setIn("123".byteInputStream())
        assertThrows<IllegalArgumentException> {
            BuyLotto()
        }
    }
    @Test
    fun `입력받은 가격이 null인 경우 에러 발생`() {
        System.setIn(InputStream.nullInputStream())
        assertThrows<IllegalArgumentException> {
            BuyLotto()
        }
    }
    @Test
    fun `BuyLotto의 기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000")
                assertThat(output()).contains(
                    "8개를 구매했습니다.",
                    "[1, 2, 3, 4, 5, 6]",
                    "[7, 8, 9, 10, 11, 12]",
                    "[13, 14, 15, 16, 17, 18]",
                    "[19, 20, 21, 22, 23, 24]",
                    "[25, 26, 27, 28, 29, 30]",
                    "[31, 32, 33, 34, 35, 36]",
                    "[37, 38, 39, 40, 41, 42]",
                    "[43, 44, 45, 46, 47, 48]",
                )
            },
            listOf(1,2,3,4,5,6),
            listOf(7,8,9,10,11,12),
            listOf(13,14,15,16,17,18),
            listOf(19,20,21,22,23,24),
            listOf(25,26,27,28,29,30),
            listOf(31,32,33,34,35,36),
            listOf(37,38,39,40,41,42),
            listOf(43,44,45,46,47,48),
        )
    }

    override fun runMain() {
        val buyLotto = BuyLotto()
    }

}