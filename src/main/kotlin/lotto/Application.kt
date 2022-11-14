package lotto

fun main() {
    try{
        val lottoGenerator = LottoGenerator()
        val user = User()

        val money = lottoGenerator.inputMoney()
        val lottery = lottoGenerator.makeRandomNumber(money)

        val inputLotto = user.userInput()
        val inputBonusNum = user.userBonusInput(inputLotto.getList())

    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
