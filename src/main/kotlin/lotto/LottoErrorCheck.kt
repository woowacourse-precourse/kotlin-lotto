package lotto

object LottoErrorCheck {

    fun checksize(checklotto:MutableList<Int>){
        if(checklotto.size!=6)
            throw(IllegalArgumentException)
    }
}