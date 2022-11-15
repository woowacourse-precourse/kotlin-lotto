package lotto

import camp.nextstep.edu.missionutils.Randoms

class PrintLottery(private val lottoTicket : Int, private val lotto: MutableList<List<Int>>){
    init{
        for(i in 0 until lottoTicket) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 46, 6).sorted()
            println(numbers)
            lotto.add(numbers)
        }
    }
}