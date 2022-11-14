package lotto

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PrintTest {
    lateinit var lottoPrinter:LottoPrinter

    @BeforeEach
    fun setUp(){
        lottoPrinter= LottoPrinter()
    }

}