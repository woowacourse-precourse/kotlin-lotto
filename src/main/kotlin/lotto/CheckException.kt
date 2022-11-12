package lotto

class CheckException {



    fun checkMod(amount : String){

        if (amount.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요!")
        }

    }

    fun checkInt(amount: String){
        var amountToInt = amount.toInt()
        if (amountToInt.javaClass != Int::class.java) {
            throw IllegalArgumentException("[ERROR] 금액을 숫자 형태로 입력해주세요!")
        }
    }

}