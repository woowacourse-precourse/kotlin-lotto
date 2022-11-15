package lotto

import javax.swing.JOptionPane

class Bonus(bonusNums : Int) {

    init {
        require(bonusNums.toString().length == BONUS_SIZE){
            throw IllegalArgumentException(JOptionPane.ERROR_MESSAGE.toString() + LottoExecptions.BONUS_LENGTH_ERROR)
        }
    }

    companion object{
        const val BONUS_SIZE = 1
    }

}