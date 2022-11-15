package lotto

class LottoGameStarter {
    fun gameStarter(){
        val money = readLine()
        checkMoneyError(money)

        val winningNumbers = readLine()!!.split(",")
        checkWinningNumError(winningNumbers)
        for(i in 0..5) checkWinningNumError(winningNumbers[i].toInt())

        val bonusNumber = readLine()
        checkBonusNumberError(bonusNumber)
    }

    fun checkMoneyError(money:String?){
        if(money!!.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] 금액은 숫자를 입력해야 합니다.")
        if(money.toInt() < 1000) throw IllegalArgumentException("[ERROR] 1000원 이상의 금액을 내야 로또 구입이 가능합니다.")
    }

    fun checkWinningNumError(winningNumbers: List<String>){
        if(winningNumbers.size != 6) throw IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.")
        if(winningNumbers != winningNumbers.distinct()) throw IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.")
    }

    fun checkWinningNumError(winningNumber: Int){
        if(winningNumber !is Int) throw IllegalArgumentException("[ERROR] 로또 번호는 정수인 숫자여야 합니다.")
        if(winningNumber < 1 || winningNumber > 45) throw IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위 내여야 합니다.")
    }

    fun checkBonusNumberError(bonusNumber: String?){
        if(bonusNumber!!.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] 보너스 번호는 정수인 숫자여야 합니다.")
        if(bonusNumber!!.toInt() < 1 || bonusNumber!!.toInt() > 45) throw IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위 내여야 합니다.")
    }
}
