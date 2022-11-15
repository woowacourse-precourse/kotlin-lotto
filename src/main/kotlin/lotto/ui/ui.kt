package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoWinningDetails

class ui {
    fun moneyInput() : Int{
        var money  = 0

        try {
            println("구입금액을 입력해 주세요.")
            money = Console.readLine().toInt()
            MoneyTypeException(money.toString())
            moneyInputNotDivideException(money)
        } catch (e : IllegalArgumentException){
            println("[ERROR] 금액은 1000원으로 나누어 떨어지는 숫자여야 합니다.")
            return 1
        }
        return money
    }

    fun correctNumber() : List<Int>{
        println("당첨 번호를 입력해 주세요.")
        var correctNumberOld = Console.readLine().split(",")
        correctNumberTypeException(correctNumberOld)
        var correctNumberNew = correctNewNumberCreate(correctNumberOld)
        correctNumberRangeOverException(correctNumberNew)

        return correctNumberNew
    }
    fun correctNewNumberCreate(correctNumberOld : List<String>) : List<Int>{
        var correctNumberNew = mutableListOf<Int>()
        for (i in correctNumberOld){
            correctNumberNew.add(i.toInt())
        }
        return correctNumberNew.toList()
    }

    fun bonusNumber() : Int {
        println("보너스 번호를 입력해 주세요.")
        var bonusNumber = Console.readLine()
        bonusNumberTypeException(bonusNumber)
        bonusNumberRangeOverException(bonusNumber.toInt())
        return bonusNumber.toInt()
    }

    fun printLottoResult(three : Int, four : Int, five : Int, fivebonus : Int, six : Int){
        println("당첨 통계\n---")
        print(LottoWinningDetails.THREE.message)
        println(" - "+three.toString()+"개")
        print(LottoWinningDetails.FOUR.message)
        println(" - "+four.toString()+"개")
        print(LottoWinningDetails.FIVE.message)
        println(" - "+five.toString()+"개")
        print(LottoWinningDetails.FIVEBONUS.message)
        println(" - "+fivebonus.toString()+"개")
        print(LottoWinningDetails.SIX.message)
        println(" - "+six.toString()+"개")
    }
}

fun moneyInputNotDivideException(money : Int) {
    if ((money % 1000) != 0){
        throw IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.")
    }
    if (money < 1000){
        throw IllegalArgumentException("[ERROR] 금액이 1000원을 넘지 않습니다.")
    }
}

fun correctNumberRangeOverException(correctNumber : List<Int>){
    for (i in correctNumber){
        if (i < 1 || i > 46){
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}

fun bonusNumberRangeOverException(bonusNumber: Int){
    if (bonusNumber < 1 || bonusNumber > 46){
        println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun MoneyTypeException(money : String){
    money.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")
}

fun correctNumberTypeException(correctNumber: List<String>){
    for (i in correctNumber) {
        i.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.")
    }
}

fun bonusNumberTypeException(bonusNumber: String){
    bonusNumber.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
}