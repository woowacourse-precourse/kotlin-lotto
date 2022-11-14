package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    lateinit var machine:LottoMachine
    @BeforeEach
    fun setUp(){
        machine= LottoMachine()
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
        var result= listOf<Int>()
        for(idx in 0 .. 1000){
            result=machine.makeRandomNumber()
            Assertions.assertEquals(6,result.size)
            println(result)
        }
    }
    @Test
    fun `로또 랜덤 생성_중복되는지 테스트`() {
        var result= listOf<Int>()
        for(idx in 0 .. 1000){
            result=machine.makeRandomNumber()
            Assertions.assertEquals(6,result.distinct().size)
        }
    }
    @Test
    fun `로또 랜덤 생성_1부터 45인지 테스트`() {
        var result= listOf<Int>()
        for(idx in 0 .. 1000){
            result=machine.makeRandomNumber()
            Assertions.assertEquals(true,result[5]<=45)
            Assertions.assertEquals(true,result[0]>=1)
        }
    }
}
