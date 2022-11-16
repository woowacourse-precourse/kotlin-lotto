package lotto

private const val DOLLAR = 1000
private const val MIN_IDX=0
private const val MAX_IDX=5

private const val IS_OK=false
private const val IS_PROBLEM=true

class LottoValidCheker {

    fun checkDollar(amount: Int): Boolean = amount % DOLLAR != 0 // 1000단위 검사

    fun checkPositive(amount: Int): Boolean = amount <= 0 //양수 검사

    fun checkDuplicate(winningNum: List<Int>):Boolean = winningNum.distinct().size!=6 //중복 검사

    fun checkSize(winningNum:List<Int>):Boolean =  winningNum.size!=6 //6자리인지 검사

    fun checkRagne(winningNum:List<Int>):Boolean{ //1부터 45인지 검사
        if(winningNum[MIN_IDX]<=0 || winningNum[MAX_IDX]>45){
            return IS_PROBLEM
        }
        return IS_OK
    }

    fun checkBonusDuplicate(winningNum:Lotto, bonusNum:Int):Boolean{ //보너스 번호가 당첨번호와 중복되어서는 안됨
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