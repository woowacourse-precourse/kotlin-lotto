package lotto.bank

import lotto.Lotto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BankTest {

    lateinit var bank: Bank
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @BeforeEach
    fun initCustomer() {
        bank = BankImpl()
    }

    @Test
    fun `로또 등수 계산 함수 테스트1`() {
        val receivedMainLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val receivedBonusLottoNumber = 7
        bank.calcPrizeGrade(receivedMainLottoNumbers, receivedBonusLottoNumber, lotto)
        assertThat(bank.prizeGrades)
            .isEqualTo(listOf(1, 0, 0, 0, 0))
    }

    @Test
    fun `로또 등수 계산 함수 테스트2`() {
        val receivedMainLottoNumbers = listOf(1, 2, 3, 11, 5, 6)
        val receivedBonusLottoNumber = 7
        bank.calcPrizeGrade(receivedMainLottoNumbers, receivedBonusLottoNumber, lotto)
        assertThat(bank.prizeGrades)
            .isEqualTo(listOf(0, 0, 1, 0, 0))
    }

    @Test
    fun `로또 등수 계산 함수 테스트3`() {
        val receivedMainLottoNumbers = listOf(1, 2, 32, 4, 87, 6)
        val receivedBonusLottoNumber = 7
        bank.calcPrizeGrade(receivedMainLottoNumbers, receivedBonusLottoNumber, lotto)
        assertThat(bank.prizeGrades)
            .isEqualTo(listOf(0, 0, 0, 1, 0))
    }

    @Test
    fun `로또 등수 계산 함수 테스트4`() {
        val receivedMainLottoNumbers = listOf(1, 2, 3, 4, 5, 11)
        val receivedBonusLottoNumber = 6
        bank.calcPrizeGrade(receivedMainLottoNumbers, receivedBonusLottoNumber, lotto)
        assertThat(bank.prizeGrades)
            .isEqualTo(listOf(0, 1, 0, 0, 0))
    }

    @Test
    fun `수익률 계산 함수 테스트`() {
        val prizeGrades = listOf(1, 1, 1, 1, 1)
        bank.calcEarningRate(5000, prizeGrades)
        assertThat(bank.earningRate)
            .isEqualTo((2000000000 + 30000000 + 1500000 + 50000 + 5000).toFloat() / 5000)
    }
}
