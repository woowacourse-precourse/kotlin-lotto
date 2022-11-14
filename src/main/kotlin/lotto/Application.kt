package lotto

fun main() {
    try{
        val lottoGenerator = LottoGenerator()
        val user = User()

        val money = lottoGenerator.inputMoney()
        val lottery = lottoGenerator.makeRandomNumber(money)

        val inputLotto = user.userInput()

    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
