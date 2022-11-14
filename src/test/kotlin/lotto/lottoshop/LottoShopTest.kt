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

    @Nested
    inner class TestMainLottoNumbers {
        @Test
        fun `로또 당첨 번호 테스트 정상`() {
            val input = listOf("1","2","3","4","5","6")
            assertThat(lottoShop.getValidateMainLottoNumbers(input)).isEqualTo(listOf(1,2,3,4,5,6))
        }

        @Test
        fun `로또 당첨번호 테스트 1~45범위 아닌 번호 포함`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","3","56","5","6"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 1~45범위 아닌 번호 포함(음수 포함)`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","3","-1","5","6"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 번호 7개인경우`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","3","4","5","6","7"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 번호 5개인경우`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","3","4","5"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 알파벳이 포함된경우`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","ab","4","5","6","7"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 한글이 포함된경우`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","ㅅㄴ","4","5","6","7"))
            }
        }

        @Test
        fun `로또 당첨번호 테스트 기호가 포함된경우`() {
            assertThrows<IllegalArgumentException> {
                lottoShop.getValidateMainLottoNumbers(listOf("1","2","-","4","5","6","7"))
            }
        }
    }
}
