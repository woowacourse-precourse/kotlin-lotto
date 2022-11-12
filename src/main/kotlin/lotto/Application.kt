package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine
fun main() {
    val display = Display()
    val client = Client()
    display.printRequirePurchaseAmount()
    client.inputPurchaseAmount()

}

fun makeLotto(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
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