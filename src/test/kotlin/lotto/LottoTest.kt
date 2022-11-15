package lotto

import lotto.data.Lotto
import lotto.data.WinningLotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoShop
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또판매점_가격에맞는수량_정상`() {
        Assertions.assertThat(LottoShop.buy(25000)).hasSize(25)
    }

    @Test
    fun `로또판매점_단위가격의배수가아님_에러`() {
        assertSimpleThrows {
            Assertions.assertThat(LottoShop.buy(10500))
        }
    }

    @Test
    fun `로또생성기_생성_길이6`() {
        Assertions.assertThat(LottoGenerator.generate(1))
            .flatExtracting("numbers")
            .hasSize(6)
    }

    @RepeatedTest(10)
    fun `로또생성기_생성_중복X`() {
        Assertions.assertThat(LottoGenerator.generate(1))
            .flatExtracting("numbers")
            .doesNotHaveDuplicates()
    }

    @RepeatedTest(10)
    fun `로또생성기_생성_1to45`() {
        Assertions.assertThat(LottoGenerator.generate(1))
            .flatExtracting("numbers")
            .allMatch { it in 1..45 }
    }

    @Test
    fun `로또_길이6_정상`() {
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `로또_길이6아님_에러`() {
        assertSimpleThrows {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또_중복X_정상`() {
        Assertions.assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `로또_중복O_에러`() {
        assertSimpleThrows {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또_숫자범위1to45_정상`() {
        Assertions.assertThat(Lotto(listOf(6, 4, 1, 10, 24, 45)))
    }

    @Test
    fun `로또_숫자범위벗어남_에러`() {
        assertSimpleThrows {
            Lotto(listOf(0, 3, 5, 6, 7, 8))
        }
        assertSimpleThrows {
            Lotto(listOf(1, 3, 5, 6, 45, 46))
        }
    }

    @Test
    fun `당첨번호_중복보너스숫자_에러`() {
        assertSimpleThrows {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 3)
        }
    }

    @Test
    fun `로또당첨번호_비교`() {
        val lotto = Lotto(listOf(15, 7, 3, 24, 32, 37))
        val winning = WinningLotto(Lotto(listOf(24, 9, 37, 32, 3, 15)), 7)
        val (hitCount, isBonusHit) = winning.matches(lotto)
        Assertions.assertThat(hitCount).isEqualTo(5)
        Assertions.assertThat(isBonusHit).isEqualTo(true)
    }

    private inline fun assertSimpleThrows(executable: () -> Unit) {
        val thrown = assertThrows<IllegalArgumentException>(executable)
        Assertions.assertThat(thrown.message).contains(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
