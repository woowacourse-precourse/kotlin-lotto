package lotto

private const val DOLLAR = 1000
private const val MIN_IDX=0
private const val MAX_IDX=5

private const val IS_OK=false
private const val IS_PROBLEM=true

class LottoValidCheker {

    fun checkDollar(amount: Int): Boolean = amount % DOLLAR != 0

    fun checkPositive(amount: Int): Boolean = amount <= 0

    fun checkDuplicate(winningNum: List<Int>):Boolean = winningNum.distinct().size!=6

    fun checkSize(winningNum:List<Int>):Boolean =  winningNum.size!=6

    fun checkRagne(winningNum:List<Int>):Boolean{
        if(winningNum[MIN_IDX]<=0 || winningNum[MAX_IDX]>45){
            return IS_PROBLEM
        }
        return IS_OK
    }

    fun checkBonusDuplicate(winningNum:Lotto, bonusNum:Int):Boolean{
        if(winningNum.getNumbers().contains(bonusNum)){
            return IS_PROBLEM
        }
        return IS_OK
    }

    fun checkBonusRange(bonusNum: Int):Boolean{
        if (bonusNum<=0 || bonusNum>45){
            return IS_PROBLEM
        }
        return IS_OK
    }
}