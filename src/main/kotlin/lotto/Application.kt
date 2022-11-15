package lotto

fun main() {
    try {
        val pr = LottoInputOutput()
        pr.lottoPurchaseAmount()
    } catch (e:Exception){
        println(e.message)
    }
}
