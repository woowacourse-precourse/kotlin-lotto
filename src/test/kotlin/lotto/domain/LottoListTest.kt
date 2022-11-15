package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoListTest {
    lateinit var lottoList: LottoList
    @BeforeEach
    fun `lottoList 초기화`() {
        lottoList = LottoList(listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6))))
    }

    @Test
    fun `purchaseAmount 메서드를 사용해 로또 구매 금액을 반환`() {
        Assertions.assertThat().isEqualTo(4000)
    }
}