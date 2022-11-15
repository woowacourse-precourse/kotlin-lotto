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


}
