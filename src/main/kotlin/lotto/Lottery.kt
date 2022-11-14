package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.regex.Pattern
import kotlin.math.pow
import kotlin.math.roundToInt

class Lottery (
    private val printer: Printer
) {
    private var lottos = mutableListOf<Lotto>()
    private var sell = getSellLottoCount()
    private var winningNumber: MutableList<Int> = mutableListOf()
    private var winningResult = HashMap<String, Int>(5)


    fun start(){

        setLotto(lottos, sell)
        getWinningNumber(winningNumber)
        var bonusNumber = getBonusNumber(winningNumber)
        getWinningResult(lottos, winningNumber, bonusNumber, winningResult)
        var earningRate = getEarningRate(sell, winningResult)
        printer.printWinningResult(winningResult)
        printer.printYieldResult(earningRate)
    }

    private fun getSellLottoCount() : Int {

        printer.printGetPurchaseAmountMessage()

        val input = readLine()!!

        try {
            if (!Pattern.matches("^[0-9]*", input) || (input.toInt() % AMOUNT) != 0 || (input.toInt() / AMOUNT) == 0) {
                throw IllegalArgumentException()
            }
            else {
                val lottoAmount = input.toInt() / AMOUNT
                println("\n${lottoAmount}개를 구매했습니다.")
                return lottoAmount
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 정확한 로또 금액을 입력해 주세요.")
            return 0
        }
    }

    private fun setLotto(lottos : MutableList<Lotto>, count: Int) {

        for(i in 0 until count){
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottos.add(lotto)
            println(lotto.getLottoNumbers())
        }
    }

    // 로또 번호 오름차순
    private fun getWinningNumber(winningNumber : MutableList<Int>){

        printer.printGetWinningNumberMessage()

        val input = readLine()!!

        try{
            if(!Pattern.matches("^[1-9]*,[1-9]*,[1-9]*,[1-9]*,[1-9]*,[1-9]*\$", input)) {
                throw IllegalArgumentException("[ERROR] 공백 없이 입력해 주세요.")
            }

            else {
                var checkedNumber : MutableList<Int> = checkWinningNumberInputOvervalueException(checkWinningNumberInputOverlapException(input))
                winningNumber.addAll(checkedNumber)
            }

        } catch (e: IllegalArgumentException) {
            println("[ERROR] 공백 없이 입력해 주세요.")
        }
    }

    private fun checkWinningNumberInputOverlapException(input: String) : MutableSet<String> {

        var str = input.split(',')
        var winningSet : MutableSet<String> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

        str.forEach{
            winningSet.add(it)
        }

        try {
            if(winningSet.size != 6){
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 당첨 번호는 중복될 수 없습니다.")
            winningSet.clear()
        }

        return winningSet
    }

    private fun checkWinningNumberInputOvervalueException(input : MutableSet<String>) : MutableList<Int> {
        var winningInt : MutableList<Int> = mutableListOf()

        input.forEach {
            val num = it.toInt()
            try {
                if(num < 1 || num > 45){
                    throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                }
                else {
                    winningInt.add(num)
                }
            } catch (e: IllegalArgumentException){
                println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
        return winningInt
    }

    // 예외처리 리팩토링 필요
    private fun getBonusNumber(winningNumber: MutableList<Int>) : Int {

        printer.printGetBonusNumberMessage()

        val input = readLine()!!

        try{
            if(!Pattern.matches("^[1-9]*$", input)
                || input.toInt() < 1 || input.toInt() > 45
                || winningNumber.contains(input.toInt())){
                throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
            else {
                return input.toInt()
            }
        } catch (e: IllegalArgumentException){
            println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            return 0
        }
    }

    private fun getWinningResult(lottos: MutableList<Lotto>, winningNumber: MutableList<Int>, bonusNumber : Int, winningResult : HashMap<String, Int>){
        var threeWin = 0
        var fourWin = 0
        var fiveWin = 0
        var fiveWithBonusWin = 0
        var sixWin = 0

        lottos.forEach {
            when(it.getLottoWinning(winningNumber, bonusNumber)){
                3 -> threeWin++
                4 -> fourWin++
                5 -> fiveWin++
                6 -> sixWin++
                7 -> fiveWithBonusWin++
            }
        }

        winningResult[THREE_WIN] = threeWin
        winningResult[FOUR_WIN] = fourWin
        winningResult[FIVE_WIN] = fiveWin
        winningResult[FIVE_BONUS] = fiveWithBonusWin
        winningResult[SIX_WIN] = sixWin

    }

    private fun getEarningRate(sell : Int, winningResult: HashMap<String, Int>) : Double {
        var earn = 0

        var key = winningResult.filterValues { it != 0 }.keys
        key.forEach {
            earn += getEarnedMoney(it) * winningResult.getValue(it)
        }

        return ((earn.toFloat() / (sell * AMOUNT).toFloat()) * 100).toDouble()
    }

    private fun getEarnedMoney(grade: String) : Int {
        var money = 0

        when(grade){
            "threeWin" -> money = Money.THREE.value
            "fourWin" -> money = Money.FOUR.value
            "fiveWin" -> money = Money.FIVE.value
            "sixWin" -> money = Money.SIX.value
            "fiveWithBonusWin" -> money = Money.FIVE_BONUS.value
        }

        return money
    }

}