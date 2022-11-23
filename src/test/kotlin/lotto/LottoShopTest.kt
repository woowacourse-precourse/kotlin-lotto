package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.Lotto
import lotto.ui.View
import lotto.domain.LottoShop
import lotto.domain.LottoService
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest : NsTest() {
    private val lottoShop = LottoShop()
    private val lottoService = LottoService()

//    @Test
//    fun `구입 금액 입력 함수 테스트 - 1`() {
//        assertSimpleTest {
//            run("8000")
//            assertThat(output()).contains(
//                "8개를 구매했습니다."
//            )
//        }
//    }

//    @Test
//    fun `구매 갯수 만큼 로또 번호를 생성해 리턴하는 함수 테스트 - 2`() {
//        assertRandomUniqueNumbersInRangeTest(
//            {
//                run("8000")
//                assertThat(output()).contains(
//                    "[8, 21, 23, 41, 42, 43]",
//                    "[3, 5, 11, 16, 32, 38]",
//                    "[7, 11, 16, 35, 36, 44]",
//                    "[1, 8, 11, 31, 41, 42]",
//                    "[13, 14, 16, 38, 42, 45]",
//                    "[7, 11, 30, 40, 42, 43]",
//                    "[2, 13, 22, 32, 38, 45]",
//                    "[1, 3, 5, 14, 22, 45]"
//                )
//            },
//            listOf(8, 21, 23, 41, 42, 43),
//            listOf(3, 5, 11, 16, 32, 38),
//            listOf(7, 11, 16, 35, 36, 44),
//            listOf(1, 8, 11, 31, 41, 42),
//            listOf(13, 14, 16, 38, 42, 45),
//            listOf(7, 11, 30, 40, 42, 43),
//            listOf(2, 13, 22, 32, 38, 45),
//            listOf(1, 3, 5, 14, 22, 45)
//        )
//    }

//    @Test
//    fun `당첨 번호를 입력받고 예외 처리 후 리턴하는 함수 테스트 - 3`() {
//        assertSimpleTest {
//            run("1,2,3,4,5,6")
//            assertThat(output()).contains(
//                "[1, 2, 3, 4, 5, 6]"
//            )
//        }
//    }

    @Test
    fun `보너스 번호를 입력받고 예외 처리 후 리턴하는 함수 - 4`() {
        assertSimpleTest {
            run("1,2,3,4,5,6", "7")
            assertThat(output()).contains(
                "7"
            )
        }
    }

    override fun runMain() {
        // 1번 테스트: val countOfLottoNumber = applicationService.retryGetPurchasingAmount(applicationService)
        // 2번 테스트: applicationService.getLottoNumbers(countOfLottoNumber)
        // 3번 테스트:
        val winningNumbers = lottoShop.getWinningNumbers()
        // 4번 테스트:
        if (winningNumbers != null) {
            lottoShop.getBonusNumber(winningNumbers)
        }
    }

    @Test
    fun `winningLotto 정상 출력 테스트`() {
        val countOfLotto = 8
        val lottoNumbers = lottoShop.getLottoNumbers(countOfLotto)
        View.showPurchasedLotteries(lottoNumbers)
        val winningNumbers = Lotto(listOf(4, 3, 7, 9, 12, 36))
        val bonusNumber = 45
        val winningLotto = lottoService.isWinningLotto(lottoNumbers, winningNumbers, bonusNumber)
        println(winningLotto.toString())
    }
}