package lotto

import camp.nextstep.edu.missionutils.Randoms

class MakeLotto {

    fun userpicknumber (ticket: Int) : MutableList<List<Int>> {
        val numbers = mutableListOf<List<Int>>()
        for (i in 0 until ticket) {
            val number = Randoms.pickUniqueNumbersInRange(1, 45 ,6)
            numbers.add(number)
            val checkdistinct = number.distinct()
            if (checkdistinct.size != 6) {
                throw IllegalArgumentException("[Error] 중복된 수 발견") }
        }
        printusernumber(numbers)
        return numbers
    }

    fun printusernumber (a:MutableList<List<Int>>) {
        for (i in 0 until a.size)
        {
            println("${a[i]}")
        }
    }

}