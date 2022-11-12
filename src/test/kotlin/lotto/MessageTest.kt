package lotto

import lotto.domain.Message.showCountOfLotto
import org.junit.jupiter.api.Test

class MessageTest {
    @Test
    fun `구입한 로또 장 수 출력`() {
        val countOfLotto = 14
        showCountOfLotto(countOfLotto)
    }
}