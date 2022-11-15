package lotto

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
}
