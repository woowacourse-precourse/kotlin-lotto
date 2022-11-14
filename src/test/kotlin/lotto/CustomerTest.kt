package lotto

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CustomerTest : NsTest() {

    lateinit var customer: Customer

    @BeforeEach
    fun initCustomer() {
        customer = Customer()
    }

    @Test
    fun `메인 로또 번호 입력 함수 확인`() {
        val input = "1,2,3,4,5,6"
        run(input)
        assertThat(customer.getMainLottoNumbers()).isEqualTo(listOf("1", "2", "3", "4", "5", "6"))
    }

    @Test
    fun `메인 로또 번호 입력 함수 추후 오류 사항(알파벳 입력)`() {
        val input = "1,2,3,4,5,asd"
        run(input)
        assertThat(customer.getMainLottoNumbers()).isEqualTo(listOf("1", "2", "3", "4", "5", "asd"))
    }

    @Test
    fun `메인 로또 번호 입력 함수 추후 오류 사항(한글 입력)`() {
        val input = "1,2,3,4,5,알랄라"
        run(input)
        assertThat(customer.getMainLottoNumbers()).isEqualTo(listOf("1", "2", "3", "4", "5", "알랄라"))
    }

    @Test
    fun `보너스 숫자 입력 함수 확인`() {
        val input = "1"
        run(input)
        assertThat(customer.getBonusLottoNumber()).isEqualTo("1")
    }

    @Test
    fun `보너스 숫자 입력 추후 오류사항(알파벳 입력)`() {
        val input = "a"
        run(input)
        assertThat(customer.getBonusLottoNumber()).isEqualTo("a")
    }

    @Test
    fun `보너스 숫자 입력 함수 추후 오류사항(한글 입력)`() {
        val input = "ㅂ"
        run(input)
        assertThat(customer.getBonusLottoNumber()).isEqualTo("ㅂ")
    }

    override fun runMain() {
    }
}
