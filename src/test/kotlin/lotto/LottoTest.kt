package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.Randoms

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

    @Test
    fun `랜덤으로 숫자 6개 생성해 로또 생성`() {
        var lottoNum: MutableList<Int>
        while (true) {
            val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            if (nums.distinct().size == 6) {
                lottoNum = nums
                break
            }
        }
        lottoNum.sort()
        assertDoesNotThrow { Lotto(lottoNum) }
    }
}
