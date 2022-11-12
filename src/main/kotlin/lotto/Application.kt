package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine
fun main() {
    val display = Display()
    val client = Client()
    display.printRequirePurchaseAmount()

    client.inputPurchaseAmount()
    client.purchaseLotto()

    // 발행한 로또 수량 및 번호 출력
    display.printLottoCount(client.purchaseCount)
    display.printLottos(client.purchaseLottos)

    // 당첨 번호 입력
    display.printRequireWinningNumber()
    client.inputWinningNumbers()
    client.inputBonusNumber()
}

fun makeBonusNumber(lottoNumbers: List<Int>): Int {
    var bonusNumber: Int
    while(true) {
        bonusNumber = Randoms.pickNumberInRange(1, 45)
        if (!lottoNumbers.contains(bonusNumber))
            break
    }
    return bonusNumber
}