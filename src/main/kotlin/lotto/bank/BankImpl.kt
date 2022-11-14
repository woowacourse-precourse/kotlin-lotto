package lotto.bank

import lotto.Lotto
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.AtFixedRate
import kotlin.properties.Delegates

class BankImpl : Bank {
    var prizeGrades = listOf<Int>()
    var earningRate by Delegates.notNull<Float>()
    override fun calcPrizeGrade() {
        TODO("Not yet implemented")
    }

    override fun calcWinningMainLottoNumbers(receivedMainLottoNumbers: List<Int>, lotto: Lotto) {
        TODO("Not yet implemented")
    }

    override fun calcWinningBonusLottoNumber(receivedBonusLottoNumber: Int, lotto: Lotto) {
        TODO("Not yet implemented")
    }

    override fun calcEarningRate(purchaseAmount: Int, prizeGrades: List<Int>) {
        TODO("Not yet implemented")
    }
}
