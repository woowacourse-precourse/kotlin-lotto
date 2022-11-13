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
            println("보너스 번호를 입력해 주세요.")
            return Console.readLine()
        }

        fun printResultStats(rankCount: List<Int>, earningsRate: String) {
            val sb = StringBuilder()
            sb.append("당첨 통계").append('\n').append("---").append('\n')
            sb.append("3개 일치 (5,000원) - ${rankCount[4]}개").append('\n')
            sb.append("4개 일치 (50,000원) - ${rankCount[3]}개").append('\n')
            sb.append("5개 일치 (1,500,000원) - ${rankCount[2]}개").append('\n')
            sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankCount[1]}개").append('\n')
            sb.append("6개 일치, (2,000,000,000원) - ${rankCount[0]}개").append('\n')
            sb.append("총 수익률은 $earningsRate%입니다.")
            print(sb.toString())
        }
    }

}