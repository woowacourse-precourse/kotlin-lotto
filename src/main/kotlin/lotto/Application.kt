package lotto

fun main() {

    val lottoMachine=LottoMachine(LottoPrinter(),LottoConsole())

    try {
        lottoMachine.startLottoProgram()
    } catch (e:IllegalArgumentException){
        println(e.message)
    }
}
