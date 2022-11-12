package lotto

import lotto.constant.LOTTO_NUM_RANGE_END
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    private val winLotto = listOf(1, 2, 3, 4, 5, 6, 7)
    private val lotties = listOf(
        listOf(1, 2, 3, 4, 5, 6), //6개 일치
        listOf(7, 1, 2, 3, 4, 5), // 5개 일치 + 보너스 일치
        listOf(1, 2, 3, 4, 5, 8), //5개 일치
        listOf(3, 1, 2, 4, 9, 10), // 4개 일치
        listOf(1, 2, 3, 10, 11, 12), // 3개 일치
        listOf(1, 2, 13, 10, 11, 12), // 2개 일치
        listOf(1, 15, 14, 10, 11, 12), // 1개 일치
        listOf(16, 15, 14, 10, 11, 12), // 0개 일치
        listOf(16, 15, 14, 10, 11, 7), // 0개 일치 + 보너스 일치
        listOf(16, 15, 14, 10, 1, 7), // 1개 일치 + 보너스 일치
        listOf(16, 15, 14, 2, 1, 7), // 2개 일치 + 보너스 일치
        listOf(16, 15, 3, 2, 1, 7), // 3개 일치 + 보너스 일치
        listOf(16, 4, 3, 2, 1, 7), // 4개 일치 + 보너스 일치

    )
    private val lottoGrades = listOf(
        1,
        2,
        3,
        4,
        5,
        0,
        0,
        0,
        0,
        0,
        0,
        5,
        4
    )
    private val sameLottoNumbersResult = listOf(
        Pair(6, false),
        Pair(5, true),
        Pair(5, false),
        Pair(4, false),
        Pair(3, false),
        Pair(2, false),
        Pair(1, false),
        Pair(0, false),
        Pair(0, true),
        Pair(1, true),
        Pair(2, true),
        Pair(3, true),
        Pair(4, true),
    )


    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 등수 출력`() {
        sameLottoNumbersResult.forEachIndexed { idx, result ->
            assertThat(parseResultToGrade(result)).isEqualTo(lottoGrades[idx])
        }
    }

    @Test
    fun `일치하는 로또 번호 개수 확인`() {
        lotties.forEachIndexed { idx, lotto ->
            assertThat(getSameCount(winLotto, lotto)).isEqualTo(sameLottoNumbersResult[idx])
        }
    }

    private fun parseResultToGrade(result: Pair<Int, Boolean>): Int {
        return when (result.first) {
            3 -> 5
            4 -> 4
            5 -> {
                if (result.second) 2
                else 3
            }
            6 -> 1
            else -> 0
        }
    }

    private fun getSameCount(winLotto: List<Int>, lotto: List<Int>): Pair<Int, Boolean> {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        var sameCnt = 0
        var isBonusSame = false

        winLotto.forEach {
            used[it] = true
        }

        lotto.forEach {
            if (used[it]) {
                if (winLotto[winLotto.lastIndex] == it) isBonusSame = true
                else sameCnt++
            }
        }
        return Pair(sameCnt, isBonusSame)
    }
}
