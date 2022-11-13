package lottery

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.reflect.Method
import java.lang.reflect.InvocationTargetException

internal class LotteryTest {
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val standardOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `등급별 당첨 개수 검증`() {

    }

    @Test
    fun `수익률 계산 검증`() {

    }

}
