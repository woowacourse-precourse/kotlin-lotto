package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.math.exp

internal class JudgementTest {
    private lateinit var judgement: Judgement

    @BeforeEach
    fun setUp() {
        judgement = Judgement()
    }

    @Test
    fun `로또 번호와 당첨 번호에서 일치하는 번호의 개수를 반환한다`() {
        val lottoNumber = listOf(1,28,7,6,19,44)
        val winningNumber = listOf(1,2,3,4,5,6)
        val actual = judgement.countMatchNumber(lottoNumber, winningNumber)
        val expected = 2
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호에 보너스 볼이 포함되어 있는지 검사한다`() {
        val actual = judgement.checkBonusBall(listOf(1,2,3,4,5,6), 3)
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }
}