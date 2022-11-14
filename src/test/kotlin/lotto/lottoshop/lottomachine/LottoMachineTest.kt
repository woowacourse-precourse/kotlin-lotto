package lotto.lottoshop.lottomachine

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMachineTest : NsTest() {

    lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun initCustomer() {
        lottoMachine = LottoMachineImpl()
    }

    @Test
    fun `로또 발행 테스트`() {
        Assertions.assertRandomUniqueNumbersInRangeTest(
            { assertThat(lottoMachine.drawLotto().getLottoNumbers()).isEqualTo(listOf(8, 23, 34, 41, 42, 43)) },
            listOf(8, 34, 23, 41, 42, 43)
        )
    }

    @Test
    fun `로또 발행 테스트 육안 확인`() {
        for (i in 1..100) println(lottoMachine.drawLotto().getLottoNumbers())
    }

    override fun runMain() {
    }
}
