package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val numbers = listOf(listOf(1, 2, 3, 4 , 5, 6), listOf(7, 8, 9, 10, 11, 12))
    private val answers = listOf("[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12]")
    private lateinit var generator: ExpectedNumberGenerator
    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun setUp() {
        generator = ExpectedNumberGenerator(numbers)
        lottoMachine = LottoMachine(generator)
    }

    @Test
    fun `로또 발행`() {
        val tickets = lottoMachine.publish(MONEY)
        tickets.zip(answers)
            .map { (lotto, answer) -> assertThat(lotto.getTicket()).isEqualTo(answer) }
    }

    companion object {
        const val MONEY = 2000
    }
}