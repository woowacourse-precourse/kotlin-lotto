package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1-45 범위 안에 없으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 2, 3, 4, 5, 99))
        }
    }

    // 아래에 추가 테스트 작성 가능

//    @Test
//    fun `숫자 외 문자를 받을 경우 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 6)).checkPurchaseAmount("900a")
//        }
//    }
//    @Test
//    fun `1000원 단위가 아니거나 1000원 이하일 경우 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 6)).checkPurchaseAmount("10")
//        }
//    }
}
