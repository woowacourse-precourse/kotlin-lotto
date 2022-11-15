package lotto.domain

import lotto.views.OutputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {
    @Test
    fun `구입 금액이 1000원 단위로 나누어떨어지지 않을 시 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            Purchase().validateMoney("5500")
        }
    }

    @Test
    fun `로또 출력 테스트`() {
        val lotto1 = listOf<Int>(8, 21, 23, 41, 42, 43)
        val lotto2 = listOf<Int>(3, 5, 11, 16, 32, 38)
        val lotto3 = listOf<Int>(7, 11, 16, 35, 36, 44)
        val lotto4 = listOf<Int>(1, 8, 11, 31, 41, 42)

        val lottos = LottoWrapper()
        lottos.add(Lotto(lotto1))
        lottos.add(Lotto(lotto2))
        lottos.add(Lotto(lotto3))
        lottos.add(Lotto(lotto4))

        OutputView.printLottos(lottos)
    }

    @Test
    fun `랜덤 로또 번호 생성 테스트`() {
        val lottos = Purchase().createLottos(1)
        OutputView.printLottos(lottos)
    }


}