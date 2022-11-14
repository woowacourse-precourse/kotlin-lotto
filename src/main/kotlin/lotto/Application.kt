package lotto

fun main() {
    runCatching {
        LottoProcessor(Seller(LottoGenerator()), Printer()).processLotto()
    }.onFailure {
        println(it)
    }
}
