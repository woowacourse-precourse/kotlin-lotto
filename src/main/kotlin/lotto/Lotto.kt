package lotto

import java.text.DecimalFormat

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
    fun checkAllWinLotto(purchasedLotto : List<List<Int>>,bonusNum : Int): MutableList<Int> {
        val winLotto = mutableListOf<Int>(0,0,0,0,0)
        for(i in purchasedLotto){
            val sameNum = countSameNum(i,bonusNum)
            checkWinLotto(sameNum,winLotto)
        }
        return winLotto
    }

    fun countSameNum(purchasedLotto : List<Int>,bonusNum: Int): Int {
        val purchasedLotto = purchasedLotto.toSet()
        val lotto = numbers.toSet()
        val sameNum=purchasedLotto.intersect(lotto)
        if(sameNum.size == 5){
            return checkWinBonus(lotto, bonusNum)
        }
        return sameNum.size

    }
    fun checkWinBonus(lotto : Set<Int>,bonusNum: Int): Int {
        if(lotto.contains(bonusNum)){
            return 7
        }
        return 5
    }
    fun checkWinLotto(sameNum : Int,winLotto: MutableList<Int>) {
        when(sameNum){
            3 -> winLotto[0]+=1
            4 -> winLotto[1]+=1
            5 -> winLotto[2]+=1
            7 -> winLotto[3]+=1
            6 -> winLotto[4]+=1
        }
    }
    fun printResult(winLotto : List<Int>,inputMoney: Int){
        println("당첨 통계")
        println("---")
        val money = listOf<Int>(3,4,5,7,6)
        for(i in 0..4){
            printWinLotto(winLotto[i],money[i])
        }
        rateOfReturn(winLotto, inputMoney)
    }
    fun printWinLotto(sameNum : Int, money : Int){
        val dec= DecimalFormat("#,###")
        when(money){
            3 -> println("3개 일치 (${dec.format(Money.THREE.money)}원) - ${sameNum}개")
            4 -> println("4개 일치 (${dec.format(Money.FOUR.money)}원) - ${sameNum}개")
            5 -> println("5개 일치 (${dec.format(Money.FIVE.money)}원) - ${sameNum}개")
            7 -> println("5개 일치, 보너스 볼 일치 (${dec.format(Money.BONUS.money)}원) - ${sameNum}개")
            6 -> println("6개 일치 (${dec.format(Money.SIX.money)}원) - ${sameNum}개")
        }
    }
    fun winMoney(sameNum : Int, money : Int): Int {
        when(money){
            3 -> return Money.THREE.money * sameNum
            4 -> return Money.FOUR.money * sameNum
            5 -> return Money.FIVE.money * sameNum
            7 -> return Money.BONUS.money * sameNum
            6 -> return Money.SIX.money * sameNum
        }
        return 0
    }
}
