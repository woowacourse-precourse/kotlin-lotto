package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberMaker() {
    private var lottoCount = 0
    fun makeLottoList(): MutableList<List<Int>> {
        var res: MutableList<List<Int>> = mutableListOf()
        for (i in 0 until lottoCount) {
            res.add(makeNumberList())
        }

        displayBuyNumbers(res)
        return res

    }

    private fun displayBuyNumbers(res: MutableList<List<Int>>) {
        for (list in res) {
            println(list)
        }
    }

    fun setLottoCount(value: Int) {
        this.lottoCount = value / 1000
        println("${lottoCount}개를 구매했습니다.")
    }

    fun getLottoCount(): Int {
        return this.lottoCount
    }

    private fun makeNumberList(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}