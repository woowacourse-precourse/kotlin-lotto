package lotto

import domain.RandomLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LotteriesTest {
    @DisplayName("로또가 정해진 수 만큼 만들어지는지 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = [1, 100, 50])
    fun lotteries_number(lotteryNumber: Int) {
        val lotteriesNumber: MutableList<List<Int>> = mutableListOf()
        val randomLottoGenerator = RandomLottoGenerator()
        for (i in 0 until lotteryNumber) {
            lotteriesNumber.add(randomLottoGenerator.getRandomLotto())
        }
        assertThat(lotteriesNumber.size).isEqualTo(lotteryNumber)
    }
}
