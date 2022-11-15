package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class JudgementTest {

    val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val judgement = Judgement()

    @Test
    fun `1등 1개 당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(1, 0, 0, 0, 0))
    }

    @Test
    fun `2등 1개 당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(0, 1, 0, 0, 0))
    }

    @Test
    fun `3등 1개 당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 4, 5, 9)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(0, 0, 1, 0, 0))
    }

    @Test
    fun `4등 1개 당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 4, 7, 9)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(0, 0, 0, 1, 0))
    }

    @Test
    fun `5등 1개 당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 7, 8, 9)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(13, 14, 15, 16, 17, 18)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(0, 0, 0, 0, 1))
    }

    @Test
    fun `3등 1개 5등 1개당첨`() {
        val myLottos = mutableListOf<Lotto>()
        myLottos.add(Lotto(listOf(1, 2, 3, 7, 8, 9)))
        myLottos.add(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        myLottos.add(Lotto(listOf(1, 2, 3, 4, 5, 9)))
        val result = judgement.getRank(winningLotto, 7, myLottos)
        assertThat(result).isEqualTo(listOf(0, 0, 1, 0, 1))
    }
}