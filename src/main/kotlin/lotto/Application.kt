package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun isNumber(s : String?) : Boolean {
    return if(s.isNullOrEmpty()) false
    else s.all{Character.isDigit(it)}
}

fun purchaseLotto() : Int {
    println("구매금액을 입력해 주세요.")
    val inputMoney = Console.readLine()!!.trim()

    if(!isNumber(inputMoney)) {
        throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력하셔야 됩니다.")
    }
    if(inputMoney.toInt() % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.")
    }

    return inputMoney.toInt() / 1000
}

fun getLottoTicket(lottoList : MutableList<Lotto>, countLottoTicket : Int) {
    println("${countLottoTicket}개를 구매했습니다.")
    for(i in 0 until countLottoTicket) {
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottoList.add(lotto)
        println(lotto.getLottoNumbers())
    }
}

fun inputWinningNumbers() : Lotto {
    println("당첨 번호를 입력해 주세요.")
    val inputNumber = Console.readLine().split(',')
    val winningNumber = inputNumber!!.map { it.toInt() }

    if(winningNumber.size != 6) throw IllegalArgumentException("[ERROR] 로또 번호 6개를 입력해주세요.")

    return Lotto(winningNumber)
}

fun main() {
//    TODO("프로그램 구현")
    val lottoTickets = mutableListOf<Lotto>()
//    print(purchaseLotto())
//    getLottoTicket(lottoTickets, purchaseLotto())
    val testNum = inputWinningNumbers().getLottoNumbers()
    println(testNum)

}
