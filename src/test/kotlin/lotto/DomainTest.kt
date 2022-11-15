package lotto

import lotto.domain.Lotto
import lotto.domain.LottoStaff
import lotto.domain.Prize
import lotto.domain.PrizeResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class DomainTest {

    private lateinit var lottoStaff: LottoStaff
    private lateinit var lottoNumbers: List<Int>
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0
    private lateinit var prizeResult: PrizeResult

    @BeforeEach
    fun setUp() {
        lottoStaff = LottoStaff()
        winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        prizeResult = PrizeResult()
        bonusNumber = 3
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,6,2000000000", "1,2,3,4,5,7,30000000", "1,2,9,4,5,6,1500000")
    fun checkPrizeMoneyTest(
        number1: Int,
        number2: Int,
        number3: Int,
        number4: Int,
        number5: Int,
        number6: Int,
        expected: Int
    ) {
        val lottoNumbers = listOf<Int>(number1, number2, number3, number4, number5, number6)
        val matchingCount = lottoStaff.countMatchingNumber(lottoNumbers, winningNumbers)
        val isBonusMatch = lottoStaff.checkBonusNumber(lottoNumbers, bonusNumber)
        val actual = lottoStaff.checkPrize(matchingCount, isBonusMatch).prizeMoney
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `구입 금액부터 수익률 확인까지 테스트`() {
        val purchaseMoney = 5000
        val lotteries = listOf<Lotto>(
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
            Lotto(listOf(12, 11, 13, 4, 5, 6)),
            Lotto(listOf(11, 12, 13, 18, 23, 26)),
            Lotto(listOf(25, 27, 20, 19, 11, 16)),
            Lotto(listOf(1, 2, 3, 11, 12, 16))
        )

        lotteries.forEach { lotto ->
            val matchNumberCount = lottoStaff.countMatchingNumber(lotto.getNumbers(), winningNumbers)
            val isBonusMatch = lottoStaff.checkBonusNumber(lotto.getNumbers(), bonusNumber)
            val prize = lottoStaff.checkPrize(matchNumberCount, isBonusMatch)
            prizeResult.updatePrizeResult(prize)
        }

        val actual = lottoStaff.getProfit(prizeResult.getTotalPrizeMoney(), purchaseMoney)
        assertThat(actual).isEqualTo(200.0)
    }
}