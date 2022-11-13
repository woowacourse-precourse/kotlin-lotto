package lotto

fun main() {
    LottoProcessor(Seller(LottoGenerator())).processLotto()
}
