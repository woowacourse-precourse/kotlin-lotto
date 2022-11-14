package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    lateinit var machine:LottoMachine
    @BeforeEach
    fun setUp(){
        machine= LottoMachine(LottoPrinter(), LottoConsole())
    }
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
    fun `로또 랜덤 생성_6개의 수인지 테스트`() {
        var result: Lotto
        for(idx in 0 .. 1000){
            result=machine.makeRandomNumber()
            Assertions.assertEquals(result.getNumbers().size,6)
        }
    }
    @Test
    fun `로또 랜덤 생성_중복되는지 테스트`() {
        var result: Lotto
        for(idx in 0 .. 1000) {
            result=machine.makeRandomNumber()
            Assertions.assertEquals(result.getNumbers().distinct().size,6)
        }
    }

    @Test
    fun `로또 랜덤 생성_1부터 45인지 테스트`() {
        var result:Lotto
        for(idx in 0 .. 1000){
            result=machine.makeRandomNumber()
            Assertions.assertEquals(true,result.getNumbers()[0]>=1)
            Assertions.assertEquals(true,result.getNumbers()[5]<=45)

        }
    }

    @Test
    fun `금액에 맞는 로또 갯수 생성하기`(){
        var count = 6000
        var lottoTickets=machine.makeUserLottoTickets(count)

        for(idx in 0 until lottoTickets.size){
            println(lottoTickets[idx].getNumbers())
        }
        println("=======")

    }

    @Test
    fun `로또 갯수와 로또번호 출력하기`(){
        var count = 6000
        var lottoTickets=machine.makeUserLottoTickets(count)
        machine.initializeUser(count,lottoTickets)
        machine.printMyLottoTickets()
        println("========")
    }
}
