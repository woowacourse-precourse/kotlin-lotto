package lotto

import lotto.ui.ui
import kotlin.math.*

class Lotto(private val numbers: List<Int>) { //당첨번호 로또를 넣고
    init {
        require(numbers.size == 6)

    }
    fun compare(lotto: List<Int>, bonusNumber: Int)  : Int{
        var coincidence = 0

        for (i in numbers){
            if (lotto.contains(i)){
                coincidence += 1
            }
        }
        if (coincidence == 5){
            coincidence = bonusCoincidence(lotto, bonusNumber)
        }

        return coincidence
    }

    fun bonusCoincidence(lotto: List<Int>, bonusNumber: Int) : Int {
        if (lotto.contains(bonusNumber)){
            return 7
        }
        return 5
    }

    fun LottoResult(lottoCoincidence : MutableList<Int>, buyMoney : Int) {
        var three = 0
        var four = 0
        var five = 0
        var fivebonus = 0
        var six = 0
        for (i in lottoCoincidence){
            if (i == 3){ three += 1 }
            if (i == 4){ four += 1 }
            if (i == 5){ five += 1 }
            if (i == 6){ six += 1 }
            if (i == 7){ fivebonus += 1 }
        }
        ui().printLottoResult(three, four, five, fivebonus, six)

    }

}

