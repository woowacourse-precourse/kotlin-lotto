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

    @Test
    fun `당첨 번호가 중복되면 true 리턴`() {
        var input= listOf<Int>(1,2,2,3,4,5)

        var result=validCheker.checkDuplicate(input)

        Assertions.assertEquals(result,true)
    }
    @Test
    fun `당첨 번호의 갯수가 6개가 아니면 true 리턴`() {
        var input= listOf<Int>(1,2,3,4,5)
        var input2= listOf<Int>(1,2,3,4,5,6,7,8)

        var result=validCheker.checkSize(input)
        var result2=validCheker.checkSize(input2)

        Assertions.assertEquals(result,true)
        Assertions.assertEquals(result2,true)
    }

    @Test
    fun `당첨 번호의 범위가 1부터 45가 아니면 true 리턴`() {
        var input= listOf<Int>(1,2,3,4,5,45)
        var input2= listOf<Int>(1,2,3,4,5,46)
        var input3= listOf<Int>(0,2,3,4,5,45)

        var result=validCheker.checkRagne(input)
        var result2=validCheker.checkRagne(input2)
        var result3=validCheker.checkRagne(input3)

        Assertions.assertEquals(result,false)
        Assertions.assertEquals(result2,true)
        Assertions.assertEquals(result3,true)
    }


}