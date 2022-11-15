package program
import domain.*
import utils.ExceptionHandler.getIsInputFormRight
import utils.Constants
import utils.Constants.SHOW_MATCH_STATISTICS_MESSAGE
import utils.Constants.ERROR_WRONG_INPUT_FORM

class LottoProgram {
    fun startProgram(){
        try{
            val purchaseMoney = PurchaseMoney(getPurchaseMoney()).getPurchaseMoney()
            val randomLottoes = RandomLottoNumbersGenerator(purchaseMoney).getRandomLottoes()
            val lottoNumbers = Lotto(getLottoNumbers()).getNumbers()
            val bonusNumber = BonusNumber(getBonusNumber(), lottoNumbers).getBonusNumber()
            LottoNumbersMatcher(lottoNumbers, bonusNumber, randomLottoes).calculateTotalMatchCount()
            showStatistics()
            EarningRateCalculator(purchaseMoney).showEarningRate()
        }
        catch (e: IllegalArgumentException){
        }
    }

    /**
     * 구입 금액을 얻는 함수
     */
    fun getPurchaseMoney(): Int {
        println(Constants.INPUT_PURCHASE_MONEY_MESSAGE)
        val input = readLine()
        return convertInputPurchaseMoney(input!!)
    }

    /**
     * 입력한 구입 금액을 int 로 변환하는 함수
     */
    fun convertInputPurchaseMoney(input: String): Int {
        if (!getIsInputFormRight(input)){
            println(ERROR_WRONG_INPUT_FORM)
            throw IllegalArgumentException(ERROR_WRONG_INPUT_FORM)
        }
        return input.toInt()
    }

    /**
     * 로또 번호를 얻는 함수
     */
    fun getLottoNumbers(): List<Int> {
        println("\n" + Constants.INPUT_LOTTO_NUMBER_MESSAGE)
        val input = readLine()
        return convertInputLottoNumbers(input!!)
    }

    /**
     * 입력한 로또 번호를 int 로 변환하는 함수
     */
    fun convertInputLottoNumbers(input: String): List<Int>{
        val numbers = mutableListOf<Int>()
        val inputSymbols = input.split(",")
        for (index in inputSymbols.indices){
            if (!getIsInputFormRight(inputSymbols[index])) {
                println(ERROR_WRONG_INPUT_FORM)
                throw IllegalArgumentException(ERROR_WRONG_INPUT_FORM)
            }
            numbers.add(inputSymbols[index].toInt())
        }
        return numbers
    }

    /**
     * 보너스 숫자를 얻는 함수
     */
    fun getBonusNumber(): Int{
        println("\n" + Constants.INPUT_BONUS_NUMBER_MESSAGE)
        val inputBonusNumber = readLine()
        return convertInputBonusNumber(inputBonusNumber!!)
    }

    /**
     * 입력한 보너스 숫자를 int 로 변환하는 함수
     */
    fun convertInputBonusNumber(inputBonusNumber: String): Int {
        if (!getIsInputFormRight(inputBonusNumber)){
            println(ERROR_WRONG_INPUT_FORM)
            throw IllegalArgumentException(ERROR_WRONG_INPUT_FORM)
        }
        return inputBonusNumber.toInt()
    }

    /**
     * 당첨 통계를 보여주는 함수수
     */
    fun showStatistics(){
        val matches = enumValues<MatchStorage>()
        println("\n" + SHOW_MATCH_STATISTICS_MESSAGE)
        println("---")
        for (index in matches.indices){
            println(matches[index].matchMessage + matches[index].matchCount + "개")
        }
    }
}





