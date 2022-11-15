package lotto

import domain.RandomLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("RandomLottoGenerator 클래스 테스트")
class RandomLottoGeneratorTest {

    private val randomLottoGenerator = RandomLottoGenerator()

    @Test
    @DisplayName("생성한 랜덤한 6개의 숫자가 고유한지 확인한다.")
    fun checkDuplicateLottoNumber() {
        val randomLotto = randomLottoGenerator.getRandomLotto()
        val checkLottoDuplicate = randomLotto.distinct()

        assertThat(randomLotto.size).isEqualTo(checkLottoDuplicate.size)
    }

    @Test
    @DisplayName("생성한 랜덤한 6개의 숫자가 오름차순으로 정렬되어 있는지 확인한다.")
    fun checkSortedLottoNumber() {
        val randomLotto = randomLottoGenerator.getRandomLotto()
        val sortedRandomLotto = randomLotto.sorted()

        assertThat(randomLotto == (sortedRandomLotto)).isTrue
    }
}
