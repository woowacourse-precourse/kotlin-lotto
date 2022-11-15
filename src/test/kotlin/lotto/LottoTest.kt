package lotto

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    lateinit var lotto: Lotto
    @BeforeEach
    fun `lotto 초기화`() {
        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

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
    fun `로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `contains 메서드를 사용해 로또 번호 숫자 중 인자로 주어진 숫자가 있는지 확인`() {
        val method =
        lotto.javaClass.getDeclaredMethod("contains", Int::class.java)
        method.isAccessible = true

        val input = 3
        assertThat(method.invoke(lotto, input)).isEqualTo(true)
    }

    @Test
    fun `compare 메서드에 당첨 번호와 보너스 번호를 인자로 주어 각각에 대해 일치 여부를 반환`(){
        val inputWinningLotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val inputBonusNumber = BonusNumber(6)
        assertThat(lotto.compare(inputWinningLotto, inputBonusNumber)).isEqualTo(5 to true)
    }
}
