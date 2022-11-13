package lotto.domain

class LottoStaff() {

    fun countLotto(amount:Int):Int{
        return amount/ LOTTO_PRICE
    }

    companion object{
        const val LOTTO_PRICE= 1000
    }
}