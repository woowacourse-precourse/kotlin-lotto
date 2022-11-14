package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {
    @Test
    fun `로또 구입 금액으로 로또 개수 구하는 기능 테스트()`() {
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.getLottoCountValue(10000)
        assertThat(result).isEqualTo(10)
    }
    @Test
    fun `로또 번호 구하는 기능 테스트()`(){
        val lottoGenerator = LottoGenerator()
        assertDoesNotThrow { lottoGenerator.getLottoNumber() }
    }

    @Test
    fun `로또 개수에 따른 로또 번호 집단을 구하는 기능 테스트()`(){
        val count = 8
        val lottoGenerator = LottoGenerator()
        val result = lottoGenerator.createLottoNumber(count)
        assertThat(result.distinct().size).isEqualTo(count)
    }

    @Test
    fun `당첨 번호 로또 번호인지 확인 테스트()`(){
        val params = listOf("1","2","3","4","5","6")
        val lottoGenerator = LottoGenerator()
        assertDoesNotThrow {
            lottoGenerator.checkUserInputLotto(params)
        }
    }

    @Test
    fun `당첨 번호 로또 번호인지 확인 예외 테스트 1`(){
        val params = listOf("1","2","3","4","a","6")
        val lottoGenerator = LottoGenerator()
        assertThrows<IllegalArgumentException> {
            lottoGenerator.checkUserInputLotto(params)
        }
    }

    @Test
    fun `당첨 번호 로또 번호인지 확인 예외 테스트 2`(){
        val params = listOf("1","2","3","4","47","6")
        val lottoGenerator = LottoGenerator()
        assertThrows<IllegalArgumentException> {
            lottoGenerator.checkUserInputLotto(params)
        }
    }

    @Test
    fun `당첨 번호 로또 번호인지 확인 예외 테스트 3`(){
        val params = listOf("1","2","3","4","5")
        val lottoGenerator = LottoGenerator()
        assertThrows<IllegalArgumentException> {
            lottoGenerator.checkUserInputLotto(params)
        }
    }

}