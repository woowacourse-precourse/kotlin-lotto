package lotto

import domain.RandomLottoNumbersGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomLottoNumbersGeneratorTest {
    @Test
    fun `구입 금액 만큼 로또 번호를 생성`() {
        val purchaseMoney = 6000
        Assertions.assertThat(RandomLottoNumbersGenerator(purchaseMoney).getRandomLottoes().size == 6).isTrue
    }
}