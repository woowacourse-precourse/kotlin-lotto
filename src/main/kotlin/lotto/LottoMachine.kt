package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val printer:LottoPrinter = LottoPrinter()
    private val console:LottoConsole = LottoConsole()


    fun makeRandomNumber():List<Int>{
        val numbers = mutableListOf<Int>()
        while (numbers.size < 6) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }

        return numbers.sorted()
    }
}