package lotto

import lotto.domain.LottoStaff
import lotto.domain.Prize
import lotto.domain.PrizeResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
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
        winningNumbers = listOf<Int>(1,2,3,4,5,6)
        prizeResult = PrizeResult()
        bonusNumber = 3
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,6,2000000000","1,2,3,4,5,7,30000000","1,2,9,4,5,6,1500000")
    fun checkPrizeMoneyTest(number1:Int,number2:Int,number3:Int,number4:Int,number5:Int,number6:Int, expected:Int){
        val lottoNumbers= listOf<Int>(number1,number2,number3,number4,number5,number6)
        val matchingCount = lottoStaff.countMatchingNumber(lottoNumbers,winningNumbers)
        val isBonusMatch = lottoStaff.checkBonusNumber(lottoNumbers,bonusNumber)
        val actual = lottoStaff.checkPrize(matchingCount,isBonusMatch).prizeMoney
        assertThat(actual).isEqualTo(expected)
    }


}