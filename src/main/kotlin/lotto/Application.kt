package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

class LottoNumber {
    private fun winnerNumber(): List<Int> {
        println("\n당첨 번호를 입력해 주세요.")
        val winNumber = Console.readLine().split(",").map { it.toInt() }
        Lotto(winNumber)

        println("당첨 번호 : $winNumber")
        return winNumber
    }

    private fun bonusNumber(lottoNumber: List<Int>): Int {

        println("\n보너스 번호를 입력해 주세요.")

        val bonusNumber = Console.readLine().toInt()
        require(!lottoNumber.contains(bonusNumber)) { "[ERROR] 같은 수가 포함되어 있다." }

        println(bonusNumber)
        return bonusNumber
    }

}