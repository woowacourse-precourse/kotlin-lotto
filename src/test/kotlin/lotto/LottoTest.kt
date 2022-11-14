package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    private val winning = listOf(1, 9, 8, 6, 2, 7)
    private val bonus = 4
    private var count = 0

    @BeforeEach
    fun setUp() {
        count = 0
    }

    @Test
    fun `당첨번호와 비교해서 결과로 THREE를 리턴한다`() {
        val lotto = listOf(1, 2, 3, 4, 5, 6)
        lotto.forEach { if (winning.contains(it)) count++ }
        val result: MatchResult = when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> if (lotto.contains(bonus)) {
                MatchResult.BONUS
            } else {
                MatchResult.FIVE
            }
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
        val expected = MatchResult.THREE
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `당첨번호와 비교해서 결과로 FOUR를 리턴한다`() {
        val lotto = listOf(1, 2, 9, 4, 5, 6)
        lotto.forEach { if (winning.contains(it)) count++ }
        val result: MatchResult = when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> if (lotto.contains(bonus)) {
                MatchResult.BONUS
            } else {
                MatchResult.FIVE
            }
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
        val expected = MatchResult.FOUR
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `당첨번호와 비교해서 결과로 FIVE를 리턴한다`() {
        val lotto = listOf(1, 2, 9, 8, 5, 6)
        lotto.forEach { if (winning.contains(it)) count++ }
        val result: MatchResult = when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> if (lotto.contains(bonus)) {
                MatchResult.BONUS
            } else {
                MatchResult.FIVE
            }
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
        val expected = MatchResult.FIVE
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `당첨번호와 비교해서 결과로 BONUS를 리턴한다`() {
        val lotto = listOf(1, 2, 9, 8, 4, 6)
        lotto.forEach { if (winning.contains(it)) count++ }
        val result: MatchResult = when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> if (lotto.contains(bonus)) {
                MatchResult.BONUS
            } else {
                MatchResult.FIVE
            }
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
        val expected = MatchResult.BONUS
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `당첨번호와 비교해서 결과로 SIX를 리턴한다`() {
        val lotto = listOf(1, 2, 9, 8, 7, 6)
        lotto.forEach { if (winning.contains(it)) count++ }
        val result: MatchResult = when (count) {
            3 -> MatchResult.THREE
            4 -> MatchResult.FOUR
            5 -> if (lotto.contains(bonus)) {
                MatchResult.BONUS
            } else {
                MatchResult.FIVE
            }
            6 -> MatchResult.SIX
            else -> MatchResult.FAILED
        }
        val expected = MatchResult.SIX
        assertThat(result).isEqualTo(expected)
    }
}
