package lotto.domain

import lotto.Win
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinTest {
    @Test
    fun `맞춘 번호의 수에 맞게 등수를 제대로 반환하는지 확인 (1등일 때)`() {
        val matchedBall = 6
        val isMatchedBonusBall = false
        val myPlace = Win.getMyPlace(matchedBall, isMatchedBonusBall)
        assertThat(myPlace).isEqualTo(Win.FIRST_PLACE)
    }

    @Test
    fun `맞춘 번호의 수에 맞게 등수를 제대로 반환하는지 확인 (2등일 때)`() {
        val matchedBall = 5
        val isMatchedBonusBall = true
        val myPlace = Win.getMyPlace(matchedBall, isMatchedBonusBall)
        assertThat(myPlace).isEqualTo(Win.SECOND_PLACE)
    }

    @Test
    fun `맞춘 번호의 수에 맞게 등수를 제대로 반환하는지 확인 (낙첨일 때)`() {
        val matchedBall = 2
        val isMatchedBonusBall = true
        val myPlace = Win.getMyPlace(matchedBall, isMatchedBonusBall)
        assertThat(myPlace).isEqualTo(Win.NO_LUCK)
    }

    @Test
    fun `등수에 따른 상금이 제대로 반환되는지 확인`() {
        val place = Win.FIRST_PLACE
        val answer = 2000000000
        assertThat(Win.getIncome(place)).isEqualTo(answer)
    }

}