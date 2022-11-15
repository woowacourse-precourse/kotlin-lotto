package lotto

import lotto.lottostore.Lotto
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
    @Test
    fun `빈 로또 번호일시 예외`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf())
        }
    }
     @Test
     fun `한자리가 생성이 안됬을 때`() {
         assertThrows<IllegalArgumentException> {
             Lotto(listOf(1, 2, 3, 4, 5))
         }
     }
}
