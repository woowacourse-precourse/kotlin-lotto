package lotto

interface LottoSeller {
    fun sellLotto(receivedMoney:Int) : List<Lotto>
}