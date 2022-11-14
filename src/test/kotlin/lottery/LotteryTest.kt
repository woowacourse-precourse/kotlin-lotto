package lottery

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LotteryTest {
    @Test
    fun `1000 단위 구입 금액이 아니라면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            Lottery(1001, Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        }
    }

    @Test
    fun `0 입력은 허용하지 않음`() {
        assertThrows<IllegalArgumentException> {
            Lottery(0, Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        }
    }

    @Test
    fun `보너스 번호가 랜덤 로또 배열에 있다면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            Lottery(1000, Lotto(listOf(1, 2, 3, 4, 5, 6)), 6)
        }
    }

}
