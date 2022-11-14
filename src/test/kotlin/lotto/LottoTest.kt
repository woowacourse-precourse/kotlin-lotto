package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest : NsTest() {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

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
        assertThrows<IllegalArgumentException>{
            run("ab000")
        }
    }
    override fun runMain() {
        main()
    }
}
