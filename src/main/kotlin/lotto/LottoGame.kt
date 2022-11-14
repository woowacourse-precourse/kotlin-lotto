package lotto

import camp.nextstep.edu.missionutils.Console

class LottoGame {
    lateinit var lottoNum : Lotto
    var bonus : Int = 0
    val util = Util()
    val generator = LottoNumGenerator()
    val vendingMachine = LottoVendingMachine()
    val calculator = Calculator()

    fun inputLottoNum():List<Int>{
        println("당첨 번호를 입력해 주세요.")
        var input = Console.readLine()
        util.isRightForm(input)
        return util.changeInputToLotto(input)
    }

    fun inputBonusNum():Int{
        println("보너스 번호를 입력해 주세요.")
        var input = Console.readLine()
        util.checkBonusNum(input, lottoNum)
        var bonus = input.toInt()
        return bonus
    }

    fun printResult(score:List<Int>, profit: Double){
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${score[0]}개")
        println("4개 일치 (50,000원) - ${score[1]}개")
        println("5개 일치 (1,500,000원) - ${score[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${score[3]}개")
        println("6개 일치 (2,000,000,000원) - ${score[4]}개")
        println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.")
    }
    fun playLottoGame(){
        val amount = vendingMachine.countMoney(vendingMachine.inputMoney())
        if(amount==-1)
            return
        val lottoList = generator.makeLottoNum(amount)
        lottoNum = Lotto(inputLottoNum())
        bonus = inputBonusNum()
        val score = calculator.compareLottoNum(lottoList, lottoNum, bonus)
        val profit = calculator.calculateYield(amount, score)
        printResult(score, profit)
    }
}