package lotto

import lotto.ui.ui
import kotlin.math.*

class Lotto(private val numbers: List<Int>) { //당첨번호 로또를 넣고
    init {
        require(numbers.size == 6)
        mutipleException(numbers)
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
        profitPercent(three, four, five, fivebonus, six, buyMoney)
    }

    fun profitPercent(three : Int, four : Int, five : Int, fivebonus : Int, six : Int, buyMoney : Int) {
        var totalMoney = three * 5000 + four * 50000 + five * 1500000 + fivebonus * 30000000 + six * 2000000000
        var moneyRatio = totalMoney.toDouble() / buyMoney.toDouble() * 100.0
        moneyRatio = round(moneyRatio*10)/10
        println("총 수익률은 $moneyRatio%입니다.")
    }

    fun mutipleException(numbers: List<Int>) {
        for (i in numbers.indices){
            for (j in numbers.indices){
                multipleExceptionDetail(i,j)
            }
        }
    }
    fun multipleExceptionDetail(i : Int, j : Int){
        if (i != j){
            if (numbers[i] == numbers[j]){
                println("[ERROR] 로또 번호가 중복되었습니다.")
                throw IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.")
            }
        }
    }
}

