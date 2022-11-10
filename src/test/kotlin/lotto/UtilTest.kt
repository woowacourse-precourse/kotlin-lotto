package lotto

import lotto.util.divideToNums
import lotto.util.readInt
import lotto.util.requireWithPrint
import lotto.util.toPriceFormatted
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@Suppress("NonASCIICharacters")
class UtilTest {
    @Test
    fun `숫자를 읽었을 때 숫자가 아닌 경우 예외를 발생시킨다`() {
        systemSetIn("hi")
        assertThrows<IllegalArgumentException> {
            readInt()
        }
    }

    @Test
    fun `예외가 발생하면 에러 메시지를 출력 후 종료한다`() {
        val output = systemSetOut()
        assertThrows<IllegalArgumentException> {
            requireWithPrint(false, "test")
        }
        assert(output.toString().contains(ERROR_MESSAGE))
    }

    @Test
    fun `숫자를 1000 단위마다 쉼표로 끊어서 표시할 수 있어야 한다`() {
        val num = 2000000000
        val expect = "2,000,000,000"
        assert(num.toPriceFormatted() == expect)
    }

    @Test
    fun `숫자를 콤마 기준으로 나눌 수 있어야 한다`() {
        val input = "1,2,311,4"
        val expect = listOf(1, 2, 311, 4)
        assert(input.divideToNums(",") == expect)
    }

    @Test
    fun `숫자를 콤마 기준으로 나눌 때 공백은 무시한다`() {
        val input = "1, 2, 311, 4    "
        val expect = listOf(1, 2, 311, 4)
        assert(input.divideToNums(",") == expect)
    }

    private fun systemSetOut(): ByteArrayOutputStream {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
        return output
    }

    private fun systemSetIn(input: String) {
        System.setIn(input.byteInputStream())
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}