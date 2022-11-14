package lotto

fun main() {
    try{
        val lottoGenerator = LottoGenerator()

        val money = lottoGenerator.inputMoney()

    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
