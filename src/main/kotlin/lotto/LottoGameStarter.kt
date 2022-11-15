package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGameStarter {
    fun gameStarter(){
        val money = readLine()
        checkMoneyError(money)

        val winningNumbers = readLine()!!.split(",")
        checkWinningNumError(winningNumbers)
        for(i in 0..5) checkWinningNumError(winningNumbers[i].toInt())

        val bonusNumber = readLine()
        checkBonusNumberError(bonusNumber)

        val purchasedLotto = lottoPurchase(money!!.toInt())
        println("${purchasedLotto}개를 구매했습니다.")

        var countLotteryWin = mutableListOf<Int>(0, 0, 0, 0, 0)

        for(purchased in 1..purchasedLotto){
            val numbers = lottoNumbers()
            println(numbers)

            var count = rankLottery(numbers, winningNumbers, bonusNumber)

            if(count == 3) countLotteryWin[0]++
            else if (count == 4) countLotteryWin[1]++
            else if (count == 5) countLotteryWin[2]++
            else if (count == -1) countLotteryWin[3]++
            else if (count == 6) countLotteryWin[4]++
        }

        println("3개 일치 (5,000원) - ${countLotteryWin[0]}개")
        println("4개 일치 (50,000원) - ${countLotteryWin[1]}개")
        println("5개 일치 (1,500,000원) - ${countLotteryWin[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${countLotteryWin[3]}개")
        println("6개 일치 (2,000,000,000원) - ${countLotteryWin[4]}개")
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

    fun lottoPurchase(money: Int): Int{
        val purchasedLotto = money / 1000
        return purchasedLotto
    }

    fun lottoNumbers(): List<Int>{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }

    fun rankLottery(numbers: List<Int>, winningNumbers: List<String>, bonusNumber: String?): Int{
        var count = 0

        for(number in numbers){
            if(winningNumbers.contains(number.toString())) count++
        }

        if(count == 5 && winningNumbers.contains(bonusNumber)) count -= 6

        return count
    }
}
