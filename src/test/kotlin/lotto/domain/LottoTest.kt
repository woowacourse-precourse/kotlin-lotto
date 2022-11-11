package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonASCIICharacters")
class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호의 개수가 6개보다 적다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 1부터 45까지의 수가 아닌 경우 예외를 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 0, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또간의 겹치는 숫자의 개수를 알 수 있어야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        assert(lotto.compare(otherLotto) == 3)
    }

    @Test
    fun `로또에 특정한 숫자가 포함되어 있는지 알 수 있어야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assert(1 in lotto)
        assert(10 !in lotto)
    }
}
