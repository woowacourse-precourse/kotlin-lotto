package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class ComputerNumber(private val number: Int) {

    private val computerNumber: MutableList<Lotto> = mutableListOf()

    fun makeComputerBaseball(): List<Lotto> {
        while (computerNumber.size < number) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            computerNumber.add(Lotto(numbers.sorted()))
        }
        return computerNumber.toList()
    }

}