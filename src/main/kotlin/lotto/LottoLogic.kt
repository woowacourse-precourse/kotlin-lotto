package lotto

import camp.nextstep.edu.missionutils.Randoms
private var userLottoList = mutableListOf<List<Int>>()
private var purchaseAmount = 0
const val PRICE = 1000
class LottoLogic {
    fun lottoGenerator(): List<Int>{
        var userLotto = mutableListOf<Int>()
        userLotto.clear()
        userLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        userLotto.sort()
        return userLotto
    }

    fun lottoPurchaseAmount(lottoPay: Int): Int {
        if (lottoPay < PRICE) {
            println("[ERROR] 1,000원 이상을 입력하셔야 합니다.")
            throw IllegalArgumentException("[ERROR] 1,000원 이상을 입력하셔야 합니다.")
        } else if (lottoPay % PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 1,000원 단위를 입력하셔야 합니다.")
        }
        var purchaseAmout = lottoPay / PRICE
        return purchaseAmout
    }

    fun lottoCreateLists(count : Int):List<List<Int>>{
        for(i in 0 until count){
            userLottoList.add(lottoGenerator())
        }
        return userLottoList
    }
    fun getRate(sumPrice : Int) : Double{
        val rateOfReturn = ((sumPrice.toDouble() / userLottoList.size.toDouble())*100.0)
        return rateOfReturn
    }

    fun getUserLottoList() : List<List<Int>>{
        return userLottoList
    }
}