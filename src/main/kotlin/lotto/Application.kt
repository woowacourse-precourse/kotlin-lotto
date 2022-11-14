package lotto

import lotto.bank.BankImpl
import lotto.lottoshop.LottoShop
import lotto.lottoshop.lottomachine.LottoMachineImpl

fun main() {
    val gameHost = GameHost(Customer(), LottoShop(), LottoMachineImpl(), BankImpl())

    gameHost.apply {
        kotlin.runCatching { progressPurchaseAmount() }
            .onFailure {
                println(it.message)
                return
            }
        progressDrawLotto()
        kotlin.runCatching {
            progressMainLottoNumbers()
        }.onFailure {
            println(it.message)
            return
        }
        kotlin.runCatching {
            progressBonusLottoNumber()
        }.onFailure {
            println(it.message)
            return
        }
        progressBankService()
    }
}
