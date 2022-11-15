package lotto

import domain.LottoNumbersMatcher
import domain.MatchStorage
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoNumberMatcherTest {

    @Test
    fun `3개의 숫자가 일치했을 때의 경우`() {
        val lottoNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        val randomLottoes = listOf(listOf(1,2,3,8,9,10))
        LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
        Assertions.assertThat(MatchStorage.MATCH_THREE.matchCount).isEqualTo(1)
    }

    @Test
    fun `4개의 숫자가 일치했을 때의 경우`() {
        val lottoNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        val randomLottoes = listOf(listOf(1,2,3,4,9,10))
        LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
        Assertions.assertThat(MatchStorage.MATCH_FOUR.matchCount).isEqualTo(1)
    }

    @Test
    fun `5개의 숫자가 두 번 일치했을 때의 경우`() {
        val lottoNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        val randomLottoes = listOf(listOf(1,2,3,4,5,10), listOf(1,2,3,4,5,10))
        LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
        Assertions.assertThat(MatchStorage.MATCH_FIVE.matchCount).isEqualTo(2)
    }

    @Test
    fun `5개의 숫자와 보너스 숫자가 일치했을 때의 경우`() {
        val lottoNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        val randomLottoes = listOf(listOf(1,2,3,4,5,7))
        LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
        Assertions.assertThat(MatchStorage.MATCH_FIVE_WITH_BONUS_NUMBER.matchCount).isEqualTo(1)
    }

    @Test
    fun `6개의 숫자가 일치했을 때의 경우`() {
        val lottoNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7
        val randomLottoes = listOf(listOf(1,2,3,4,5,6))
        LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
        Assertions.assertThat(MatchStorage.MATCH_SIX.matchCount).isEqualTo(1)
    }
}