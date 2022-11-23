package lotto

import lotto.domain.DomainService
import lotto.domain.Lotto
import lotto.enums.Rating
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DomainServiceTest {
    private val domainService = DomainService()

    @Test
    fun `당첨 여부 정보를 리턴하는 함수 테스트`() {
        val lottoNumbers = mutableListOf<Lotto>(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        assertThat(domainService.isWinningLotto(lottoNumbers, winningNumber, bonusNumber)
            .also { println(it.toString()) })
            .isEqualTo(
                mutableListOf(
                    Rating.LOSE, Rating.LOSE, Rating.LOSE, Rating.LOSE, Rating.LOSE,
                    Rating.LOSE, Rating.LOSE, Rating.FIFTH
                )
            )
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호를 비교하는 함수 테스트`() {
        val lottoNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumber = Lotto(listOf(1, 2, 3, 4, 40, 41))
        val bonusNumber = 6
        assertThat(domainService.compareNumbers(lottoNumber, winningNumber, bonusNumber)
            .also { println(it) })
            .isEqualTo(4 to false)
    }

    @Test
    fun `2등 이외의 bonus 값을 false로 고정하는 함수 테스트`() {
        val hit = 5
        val bonus = true
        assertThat(domainService.isBonusNecessary(hit, bonus)
            .also { println(it) })
            .isEqualTo(5 to true)
    }

    @Test
    fun `순위를 반환하는 함수 테스트`() {
        val hitAndBonus = 5 to true
        assertThat(domainService.getRank(hitAndBonus)
            .also { println(it) })
            .isEqualTo(Rating.SECOND)
    }

    @Test
    fun `순위 갯수를 반환하는 함수 테스트`() {
        val ratings = mutableListOf<Rating>(Rating.FIFTH, Rating.FOURTH, Rating.LOSE, Rating.LOSE)
        val oneOfRatings = Rating.LOSE
        assertThat(domainService.countRank(ratings, oneOfRatings)
            .also { println(it) })
            .isEqualTo(2)
    }

    @Test
    fun `당첨 통계 중 수익률을 계산하는 함수`() {
        val ratings = mutableListOf<Rating>(Rating.FIFTH, Rating.FOURTH, Rating.LOSE, Rating.LOSE)
        val countOfLotto = 14
        assertThat(domainService.calculateIncome(ratings, countOfLotto)
            .also { println(it) })
            .isEqualTo(392.9)
    }
}