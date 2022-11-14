package lotto

object LottoError {

    private val costValidNum = "^[0-9]+$".toRegex()
    private val validNum = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$".toRegex()

    fun checkIsNum(num : String){
        if(!num.matches(costValidNum)){
            throw IllegalArgumentException("[ERROR] 양수 형식에 맞게 입력해주세요.")
        }
    }

    fun checkMoneyError(money : String){
        if (!money.matches(costValidNum)){
            throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")
        }
        if (money.toInt() % 1000 != 0 || money.toInt() < 1000) {
            throw IllegalArgumentException("[ERROR] 로또 1장의 가격은 1000원입니다.")
        }
    }

    fun checkLottoNum(userLotto : List<Int>) {
        for (i in userLotto.indices) {
            val indexNum = userLotto[i]
            if (!indexNum.toString().matches(validNum)) {
                throw IllegalArgumentException("[ERROR] ','로 공백없이 구분하고 1부터 45까지의 양수만 입력해주세요.")
            }
            if(userLotto.size != 6){
                throw IllegalArgumentException("[ERROR] 6개의 양수를 입력해주세요.")
            }

            checkDuplication(userLotto)
        }
    }

    private fun checkDuplication(number : List<Int>){
        if(number != number.distinct()){
            throw IllegalArgumentException("[ERROR] 중복을 확인해주세요.")
        }
    }

    fun checkBonusNum(bonusNum : String, userNum : MutableList<Int>){
        if (!bonusNum.matches(validNum)) {
            throw IllegalArgumentException("[ERROR] 1부터 45까지의 양수만 입력해주세요.")
        }
        if(userNum.contains(bonusNum.toInt())){
            throw IllegalArgumentException("[ERROR] 당첨번호에 입력한 숫자는 불가능합니다.")
        }
    }
}