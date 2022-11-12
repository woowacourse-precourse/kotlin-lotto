package lottery

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class LotteryTest {
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val standardOut = System.out
    private val testClass = Lottery()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `1000 단위 입력 테스트 1`() {
        val input = "10001"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { testClass.getAmount() }
    }

    @Test
    fun `1000 단위 입력 테스트 2`() {
        val input = "1000"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)
        testClass.getAmount()
        assertEquals(1000, testClass.purchase)
    }

    @Test
    fun `1000 단위 입력 테스트 3`() {
        val input = "rk"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { testClass.getAmount() }
    }

    @Test
    fun `당첨 번호 입력 테스트 1`() {
        val input = "1,2,3,4,56"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { testClass.getLotteryNumbers() }
    }

    @Test
    fun `당첨 번호 입력 테스트 2`() {
        val input = "1,2,3,4,5,6"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        testClass.getLotteryNumbers()
        assertEquals(listOf(1,2,3,4,5,6), testClass.lotteryNumbers.getList())
    }

    @Test
    fun `보너스 번호 입력 테스트 1`() {
        val input = "1"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        testClass.getBonusNumber()
        assertEquals(1, testClass.bonusNumber)
    }

    @Test
    fun `보너스 번호 입력 테스트 2`() {
        val input = "qwer"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)


        assertThrows<IllegalArgumentException> { testClass.getBonusNumber() }
    }

    @Test
    fun `보너스 번호 입력 테스트 3`() {
        val input = "46"
        val gets = ByteArrayInputStream(input.toByteArray())
        System.setIn(gets)

        assertThrows<IllegalArgumentException> { testClass.getBonusNumber() }
    }

}
