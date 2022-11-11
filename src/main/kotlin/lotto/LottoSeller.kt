package lotto

interface LottoSeller {
    fun sellLotto(receivedMoney:Int, lottoPrice:Int) : List<Lotto>
}