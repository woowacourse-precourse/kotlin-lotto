package lotto

import lotto.Computer.earnCalculate
import lotto.Computer.lottoList
import lotto.User.bonus
import lotto.User.ticket

public var matchedThree = 0
public var matchedFour = 0
public var matchedFive = 0
public var matchedSix = 0
public var matchedBonus = 0



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
            3 -> matchedThree += 1
            4 -> matchedFour += 1
            5 -> matchedFive += 1
            6 -> matchedSix += 1
//            보너스는 10으로 계산
            13 -> matchedThree += 1
            14 -> matchedFour += 1
            15 -> matchedBonus += 1
        }
    }


}
