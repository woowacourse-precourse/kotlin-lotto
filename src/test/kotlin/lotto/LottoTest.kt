package lotto

import lotto.controller.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
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

    val check = CheckException()

    @Test
    fun `입력 금액이 1000원 단위인지 확인`() {
        assertThrows<IllegalArgumentException> {
            check.checkMod("15500")
        }
    }

    @Test
    fun `입력 금액이 숫자 형태 인지 확인`() {
        assertThrows<IllegalArgumentException> {
            check.checkInt("1500ㅁ")
        }
    }

    @Test
    fun `당첨 번호를 6개 입력 했는지 확인`() {
        var num = listOf<Int>(1,2,3,4,5)

        assertThrows<IllegalArgumentException> {
            check.checkListSize(num)
        }
    }

    @Test
    fun `당첨 번호를 개수 확인`() {
        var winning = listOf<Int>(1,2,3,4,5,6)
        var lotto = listOf<Int>(4,5,6,7,8,9)

        val lottocount = Lotto(lotto)
        assertEquals(lottocount.countSameLotto(winning,lotto),3)


    }

}
