package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.resources.LOTTO_TICKET_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class StoreTest {
    @Test
    fun `기능 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val element = Store.buyTickets(LOTTO_TICKET_PRICE * 8).map { it.toList() }
                assertThat(element).isEqualTo(
                    listOf(
                        listOf(8, 21, 23, 41, 42, 43),
                        listOf(3, 5, 11, 16, 32, 38),
                        listOf(7, 11, 16, 35, 36, 44),
                        listOf(1, 8, 11, 31, 41, 42),
                        listOf(13, 14, 16, 38, 42, 45),
                        listOf(7, 11, 30, 40, 42, 43),
                        listOf(2, 13, 22, 32, 38, 45),
                        listOf(1, 3, 5, 14, 22, 45)
                    )
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `정상적인 티켓 리스트를 받는다`() {
        assertThat(
            Store.buyTickets(LOTTO_TICKET_PRICE * 2) == listOf<Lotto>()
        )
    }

    @Test
    fun `지불한 값에 맞춰 개수가 나온다`() {
        assertThat(
            Store.buyTickets(LOTTO_TICKET_PRICE * 35).toList().size == 35
        )
    }

    @Test
    fun `나눠 떨어지지 않으면 오류난다`() {
        assertThrows<IllegalArgumentException> {
            Store.buyTickets(LOTTO_TICKET_PRICE - 1)
        }
    }

    @Test
    fun `음수나 0은 오류난다`() {
        assertThrows<IllegalArgumentException> {
            Store.buyTickets(LOTTO_TICKET_PRICE * -1)
        }

        assertThrows<IllegalArgumentException> {
            Store.buyTickets(0)
        }
    }
}
