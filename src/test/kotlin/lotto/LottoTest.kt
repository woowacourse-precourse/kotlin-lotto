package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest() {
    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 숫자가 6개 인가` (){
        val lg = LottoLogic()
        val testLotto = lg.lottoGenerator()
        assertThat(testLotto.size == 6).isEqualTo(true)
        println(testLotto)
    }

    @Test
    fun `로또의 숫자가 중복되지 않는가` (){
        val lg = LottoLogic()
        val testLotto = lg.lottoGenerator()
        assertThat(testLotto.size == testLotto.distinct().size).isEqualTo(true)
        println(testLotto)
    }

    @Test
    fun `구매금액 입력에 문자가 있는가` (){
        assertSimpleTest {
            runException("ab000")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `구매금액 입력이 1,000원 이상인가` (){
        assertSimpleTest {
            runException("500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `구매금액 입력이 1,000원 단위인가` (){
        assertSimpleTest {
            runException("13600")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `구매 갯수가 출력이 올바른가` (){
        run("5000")
        assertThat(output()).contains("5개를 구매했습니다.")
    }
    override fun runMain() {
        main()
    }
    @Test
    fun `로또가 갯수에 알맞게 생성되었는가` (){
        run("5000")
    }
    @Test
    fun `로또 정답 숫자에 문자가 있는가` (){
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,s", "8")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 정답 숫자가 중복되지 않는가` (){
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,5", "8")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 정답 숫자가 범위에 드는가` (){
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,55", "8")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    @Test
    fun `로또 보너스 숫자가 중복이 되는가` (){
        assertSimpleTest {
            runException("5000", "1,2,3,4,5,6", "1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }
    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
