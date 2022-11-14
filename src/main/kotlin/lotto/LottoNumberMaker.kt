package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberMaker() {
    private var lottoCount  = 0


    fun makeLottoList(): MutableList<List<Int>> {
        val res =  mutableListOf(listOf(0))
        for(i in 0 until lottoCount){
            res.add(makeNumberList())
        }
        return res

    }
    fun setLottoCount(value: Int){
        this.lottoCount = value/1000
    }

    fun getLottoCount(): Int {
        return this.lottoCount
    }

    private fun makeNumberList(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}