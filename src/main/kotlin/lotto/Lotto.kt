package lotto

import lotto.Computer.lottoList
import lotto.User.bonus
import lotto.User.ticket

public val wonLottoList : MutableList<Int> = ArrayList()

private var count = 0
class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
    }

    fun calculateWon(){
        for (i in 0 .. ticket-1){
            matchedLottoCount(lottoList[i])
        }

    }

    fun matchedLottoCount(lotto: List<Int>){
        for ( number in lotto){
            if (number in numbers) count += 1
            if (number == bonus) count += 10
        }
        wonLottoCount()
        count = 0
    }
    private fun wonLottoCount(){
        when (count){
            3 -> wonLottoList.add(3)
            4 -> wonLottoList.add(4)
            5 -> wonLottoList.add(5)
            6 -> wonLottoList.add(6)
//            보너스는 10으로 계산
            13 -> wonLottoList.add(3)
            14 -> wonLottoList.add(4)
            15 -> wonLottoList.add(15)
        }
    }


}
