package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.*


class User(money: String) {
    val numOfLotto: Int
    var earningMoney: Long
    val purchaseMoney: Long
    private lateinit var lottoNums: List<Lotto>
    var winCase= MutableList(5){0}

    init {
        for (i in money) {
            require(i in '0'..'9') { println(INPUT_PURCHASE_AMOUNT_ERROR_MSG) }
        }
        require(money.toLong() % 1000 == 0L) { println(INPUT_PURCHASE_AMOUNT_ERROR_MSG) }

        purchaseMoney = money.toLong()
        numOfLotto = (purchaseMoney / 1000).toInt()
        earningMoney = 0L
    }
    fun makeLottoNum(){
        lottoNums = List(numOfLotto) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }
    fun printLottoNum(){
        for (case in lottoNums) case.printLottoNum()
    }
    fun calcResult() {
        for (case in lottoNums) {
            val caseNum = case.calcWin(lottoWinNums)

            if (caseNum < 0) {
                continue
            }

            winCase[caseNum]++
            earningMoney += LottoWinCaseMoney.getPrizeMoney(caseNum)
        }
    }


}