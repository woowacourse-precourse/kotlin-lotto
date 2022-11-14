package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoNumber {


    var myLotto = ArrayList<List<Int>>()


    fun getLottoNumber(money: String): ArrayList<List<Int>> {
        val count = countLotto(money)

        for (i in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            println(numbers)
            myLotto.add(numbers)
        }

        return myLotto
    }

    fun countLotto(money: String): Int {
        val count = money.toInt() / 1000
        var price = Price.COUNT

        println("$count"+price.reward)

        return count
    }
}