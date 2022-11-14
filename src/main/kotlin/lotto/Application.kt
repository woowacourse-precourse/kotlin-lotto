package lotto

fun main() {
    try{
        val lottoGenerator = LottoGenerator()
        val user = User()

        val money = lottoGenerator.inputMoney()
        val lottery = lottoGenerator.makeRandomNumber(money)

        val inputLotto = user.userInput()
        val inputBonusNum = user.userBonusInput(inputLotto.getList())

        user.makeStatistics(money, lottery, inputLotto.getList(), inputBonusNum)
    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
