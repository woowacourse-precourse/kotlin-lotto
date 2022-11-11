package lotto

object LottoErrorCheck {

    fun checkinputisnumber(input:String){
        if(input.toIntOrNull()==null)
            throw IllegalArgumentException("[ERROR] 돈은 숫자를 입력해야합니다.")
    }

    fun checklottoerrorall(checklotto:MutableList<Int>){
        checklottosize(checklotto)
    }

    fun checklottosize(checklotto:MutableList<Int>){
        if(checklotto.size!=6)
            throw IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.")
    }


}