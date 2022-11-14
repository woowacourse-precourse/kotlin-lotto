package lotto.domain

class BonusChecker(private val winning: Lotto,private val bonusString: String) {
    init{
        checkBonusValidNumber()
        val bonus = bonusString.toInt()
        checkBonusValidRange(bonus)
        checkBonusValidWithWinning(bonus)
    }
    private fun checkBonusValidNumber(){
        try {
            bonusString.toInt()
        }catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.BONUSNUMBERINTERROR.message)
            throw e
        }
    }
    private fun checkBonusValidRange(bonus:Int){
        try {
            require(bonus in 1..45)
        }catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.BONUSNUMBERRANGEERROR.message)
            throw e
        }
    }
    private fun checkBonusValidWithWinning(bonus: Int){
        try {
            val winningList = winning.returnLottoNumbers()
            require(!winningList.contains(bonus))
        } catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.BONUSNUMBERDUPLICATEDERROR.message)
            throw e
        }
    }
}