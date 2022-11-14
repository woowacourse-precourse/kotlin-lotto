package lotto

fun main() {
    val lottoMoney = LottoBuyer().inputLottoPurchasePrice()//구입 금액 입력
    val purchasedLotto = LottoSeller().calLottoCount(lottoMoney)//발행한 로또
}