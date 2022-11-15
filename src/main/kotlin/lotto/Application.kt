package lotto

import lotto.data.Message
import lotto.domain.*
import lotto.ui.GuideLotto

fun main() {
    val guideLotto = GuideLotto()
    guideLotto.printEnterPayment() // 지불 금액 안내

    val customer = Customer()
    val payment = customer.payMoney() // 지불 금액

    val seller = Seller(payment) // 판매자에게 금액 지불
    val lottoBundle = seller.setLotto() // 판매자 로또 세팅

    val lottoHost = LottoHost()
    val winningNumber = lottoHost.createWinningNumber() // 주최자 당첨번호 선정

    val checkLotto = CheckLotto(lottoBundle, winningNumber)
    val lottoResult = checkLotto.compareLotto() // 로또 확인 및 비교대조 작업

    println(lottoResult)

    val comparator = Comparator()



    guideLotto.printLottoResult(comparator.showLottoResult(lottoResult))

    guideLotto.printIncomeRate(customer.calculateIncome(comparator.getMoney(), payment))

}


