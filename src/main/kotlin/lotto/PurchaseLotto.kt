package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class PurchaseLotto {
    private fun isNumber(inputPrice : String?) : Boolean {
        return if(inputPrice.isNullOrEmpty()) false
        else inputPrice.all{Character.isDigit(it)}
    }

    fun purchase() : Int {
        println("구매금액을 입력해 주세요.")

        val inputMoney = Console.readLine()!!.trim()
        checkPrice(inputMoney)

        return inputMoney.toInt()
    }

    fun issuedLotto(money : Int) : Int{
        return money / 1000
    }

    fun getLottoTicket(lottoList : MutableList<Lotto>, countLottoTicket : Int) : List<Lotto> {
        println("\n${countLottoTicket}개를 구매했습니다.")
        for(i in 0 until countLottoTicket) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoList.add(lotto)
            printIssuedLottoList(lotto.getLottoNumbers())
        }
        return lottoList
    }

    private fun printIssuedLottoList(lottoList : List<Int>) {
        println(lottoList)
    }

    private fun checkPrice(inputMoney: String) {
        if(!isNumber(inputMoney)) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력하셔야 됩니다.")
        }
        if(inputMoney.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.")
        }
    }

}