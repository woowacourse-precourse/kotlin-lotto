
package lotto

import controller.LottoGameController

fun main() {
    val lottoGameController = LottoGameController()
    lottoGameController.startPurchaseLotteries()
    lottoGameController.makeResult()
}
