package lotto

import camp.nextstep.edu.missionutils.Console

class View {

    companion object {
        fun getPaymentAmount(): String {
            println("구입금액을 입력해 주세요.")
            return Console.readLine()
        }

        fun printNumberOfLottos(number: Int) {
            println("${number}개를 구매했습니다.")
        }

        fun printLottos(lottos: ArrayList<Lotto>) {
            lottos.forEach {
                println(it.getNumbers())
            }
        }

        fun getWinningNumber(): String {
            println("당첨 번호를 입력해 주세요.")
            return Console.readLine()
        }

        fun getBonusNumber(): String {
            TODO()
        }

        fun printResultStats() {
            TODO()
        }
    }

}