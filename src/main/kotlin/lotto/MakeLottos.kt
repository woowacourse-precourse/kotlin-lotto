package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class MakeLottos {
    private fun getRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun getLottos(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(count) {
            val lotto = getRandomNumber()
            lottos.add(Lotto(lotto))
            println(lotto)
        }

        return lottos
    }

    fun winningNumber(): List<Int> {
        println(Output.WinningNumber.message)
        val input = Console.readLine()
            .split(",")
            .map { number -> number.toInt() }
        Lotto(input)
        return input
    }

    fun bonusNumber(winningNumber: List<Int>): Int {
        println(Output.BonusNumber.message)
        val input = Console.readLine().toInt()
        checkBonusNumber(winningNumber, input)
        return input
    }

    private fun checkBonusNumber(winningNumber: List<Int>, bonusNumber: Int): Boolean {
        if(winningNumber.contains(bonusNumber))
            throw IllegalArgumentException(Error.BonusNumber.message)
        return true
    }
}