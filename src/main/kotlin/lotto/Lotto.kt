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

}
