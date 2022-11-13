package machine

import camp.nextstep.edu.missionutils.Randoms

class Machine(val inputMoney: Int) {
    private val count = inputMoney / 1000
    val lotterys = mutableListOf<List<Int>>()

    init {
        require(inputMoney % 1000 == 0) { NOT_THOUSANDS_NUMBER }
    }

    fun makeLottoNumbers(count: Int = this.count): MutableList<List<Int>> {
        println("${count}개를 구매했습니다.")
        var lotterysCount = 0
        while (lotterysCount < count) {
            lotterys += Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .toList()
            println(lotterys[lotterysCount].sorted())
            lotterysCount++
        }
        return lotterys
    }


    companion object {
        const val NOT_THOUSANDS_NUMBER = "[ERROR] 입력된 금액이 1000원단위여야 합니다."
    }
}