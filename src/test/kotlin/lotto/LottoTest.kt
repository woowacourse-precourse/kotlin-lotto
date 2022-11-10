package lotto

import org.assertj.core.api.Assertions.assertThat
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
    @Test
    fun `로또가 당첨 여부에 맞는 결과를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getResult(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(LottoResult.First)
        assertThat(lotto.getResult(listOf(1, 2, 3, 4, 5, 7), 6)).isEqualTo(LottoResult.Second)
        assertThat(lotto.getResult(listOf(1, 2, 3, 4, 5, 9), 7)).isEqualTo(LottoResult.Third)
        assertThat(lotto.getResult(listOf(1, 2, 3, 4, 9, 10), 7)).isEqualTo(LottoResult.Fourth)
        assertThat(lotto.getResult(listOf(1, 2, 3, 9, 10, 11), 7)).isEqualTo(LottoResult.Fifth)
        assertThat(lotto.getResult(listOf(1, 2, 8, 9, 10, 11), 7)).isEqualTo(LottoResult.None)
    }

    @Test
    fun `당첨번호와 보너스 번호가 1~45의 숫자가 아닌 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            "47".checkLottoNumberException()
        }
        assertThrows<IllegalArgumentException> {
            "4j".checkLottoNumberException()
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkWinningAndBonusNumberException(listOf(1,2,3,4,5,6),1)
        }
    }

    @Test
    fun `로또 당첨 금액의 총합이 계산된다`() {
        val map = HashMap<LottoResult, Int>()
        map[LottoResult.First] = 1
        map[LottoResult.Second] = 1
        map[LottoResult.Third] = 1
        map[LottoResult.Fourth] = 1
        map[LottoResult.Fifth] = 1
        assertThat(map.totalPrice()).isEqualTo(2031555000)
    }
}
