package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

class LottoNumber {

    private var money = 0
    private var number = 0
    private var lottoNumberList = mutableListOf<List<Int>>()

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

    private fun lottoRandomNumber(number: Int): MutableList<List<Int>> {

        val lottoNumberList = mutableListOf<List<Int>>()

        for (i in 1..number) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(lottoNumber)    // 에러 체크
            lottoNumberList.add(lottoNumber)
        }

        // println(lottoNumberList)
        return lottoNumberList
    }


    private fun lottoResult(winnerNumList: List<Int>, bonusNumber: Int): Array<Int> {

        var win = Array(8) { 0 }

        lottoNumberList.forEach { lottoNumber ->

            val size = lottoNumber.filter { it in winnerNumList }.size

            if (size >= 3) {
                win[size] += 1
            }
            if (size == 5 && lottoNumber.contains(bonusNumber)) {
                win[5] -= 1
                win[7] += 1
            }
        }
        // println(win)
        return win
    }
}