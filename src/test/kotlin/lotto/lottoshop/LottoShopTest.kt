package lotto.lottoshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {

    lateinit var lottoShop: LottoShop

    @BeforeEach
    fun initCustomer() {
        lottoShop = LottoShop()
    }

    @Nested
    inner class TestPurchaseAmount {
        @Test
        fun `로또 구입금액 테스트 정상`() {
            val input = "5000"
            assertThat(lottoShop.getValidatePurchaseAmount(input)).isEqualTo(5000)
        }

        @Test
        fun `로또 구입금액 테스트 1000 원 이하 구입`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidatePurchaseAmount("500")
            }
        }

        @Test
        fun `로또 구입금액 테스트 1000원 단위가 아니게 구입`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidatePurchaseAmount("1500")
            }
        }

        @Test
        fun `로또 구입금액 테스트 구입값 알파벳`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidatePurchaseAmount("ab123")
            }
        }

        @Test
        fun `로또 구입금액 테스트 구입값 한글`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidatePurchaseAmount("ㄷㄱ123")
            }
        }
    }
}
