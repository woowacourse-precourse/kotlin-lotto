package lotto

fun main() {
    try{
        val lottoGenerator = LottoGenerator()

        val money = lottoGenerator.inputMoney()
        val lottery = lottoGenerator.makeRandomNumber(money)

    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
