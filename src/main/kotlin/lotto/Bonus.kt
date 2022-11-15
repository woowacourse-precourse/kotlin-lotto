package lotto

import javax.swing.JOptionPane

class Bonus(private val bonusNums : Int) {

    init {
        require(bonusNums.toString().length == BONUS_SIZE){
            throw IllegalArgumentException(JOptionPane.ERROR_MESSAGE.toString() + LottoExecptions.BONUS_LENGTH_ERROR)
        }
        require(getBonusRangeException(bonusNums)){
            throw IllegalArgumentException(JOptionPane.ERROR_MESSAGE.toString() + LottoExecptions.BONUS_RANGE_ERROR)
        }
    }

    fun getBonusRangeException(bonus: Int) : Boolean{
        if(bonus <= Lotto.LOTTO_RANGE_START || bonus >= Lotto.LOTTO_RANGE_END){
            return false
        }
        return true
    }

    companion object{
        const val BONUS_SIZE = 1
    }

}