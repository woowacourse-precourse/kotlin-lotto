package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ResultTest {

    @Test
    fun `기능테스트(compare)`() {
        val list = mutableListOf<Int>(1, 1, 1, 0, 0)
        val lottoNumber = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val bonusNumber = 17
        val lottoLog = arrayListOf<Lotto>(lottoNumber, Lotto(listOf<Int>(1, 2, 20, 4, 5, 6)), Lotto(listOf<Int>(1, 2, 3, 4, 5, 17)), Lotto(listOf<Int>(11, 12, 13, 14, 15, 27)))
        assertEquals(list, Result.compare(lottoLog, lottoNumber, bonusNumber))
    }

    @Test
    fun `기능테스트(calculateRatio)`() {
        val result = listOf<Int>(1, 0, 0, 0, 1)
        val price = 2000
        val answer:Double = 100000250.0
        assertEquals(answer, Result.calculateRatio(price, result))
    }
}