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

}

