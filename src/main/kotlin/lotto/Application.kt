package lotto

import lotto.bank.BankImpl
import lotto.lottoshop.LottoShop
import lotto.lottoshop.lottomachine.LottoMachineImpl

fun main() {
    val gameHost = GameHost(Customer(), LottoShop(), LottoMachineImpl(), BankImpl())

    gameHost.apply {
        progressPurchaseAmount()
        progressDrawLotto()
        progressMainLottoNumbers()
        progressBonusLottoNumber()
        progressBankService()
    }
}
