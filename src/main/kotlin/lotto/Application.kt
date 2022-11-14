package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.GenerateWinningNumbers

fun getLottoTicket(lottoList : MutableList<Lotto>, countLottoTicket : Int) {
    println("${countLottoTicket}개를 구매했습니다.")
    for(i in 0 until countLottoTicket) {
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottoList.add(lotto)
        println(lotto.getLottoNumbers())
    }
}



fun main() {
//    TODO("프로그램 구현")
    val lottoTickets = mutableListOf<Lotto>()
//    print(purchaseLotto())
    val lottos = PurchaseLotto().issuedLotto(PurchaseLotto().purchase())

    getLottoTicket(lottoTickets, lottos)
    val testNum = GenerateWinningNumbers().inputWinningNumbers()


    val testPrint = testNum.getLottoNumbers().plus(GenerateWinningNumbers().inputBonusNumber())
    println(testPrint)


}
