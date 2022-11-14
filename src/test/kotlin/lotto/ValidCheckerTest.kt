package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidCheckerTest {
    lateinit var validCheker: LottoValidCheker
    @BeforeEach
    fun setUp(){
        validCheker= LottoValidCheker()
    }

    @Test
    fun `금액 입력 테스트 1000단위라면 false 리턴`(){
        var input=3000
        var result=validCheker.checkDollar(input)
        Assertions.assertEquals(result,false)
    }

    @Test
    fun `입력금액이 1000단위가 아니라면 true 리턴`() {
        var input=3200
        var result=validCheker.checkDollar(input)
        Assertions.assertEquals(result,true)
    }@Test
    fun `입력 금액이 0보다 작거나 같으면 true 리턴`() {
        var input=0
        var input2= -1000
        var result=validCheker.checkPositive(input)
        var result2=validCheker.checkPositive(input2)
        Assertions.assertEquals(result,true)
        Assertions.assertEquals(result2,true)
    }

}