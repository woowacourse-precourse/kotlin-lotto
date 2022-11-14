package lotto.view

object OutputView {
    // TODO 출력을 담당하는 뷰

    fun purchasingLottos(lottos: List<List<Int>>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.toString())
        }
        println()
    }

    fun printSummary() {
        println("당첨 통계\n---")
        // 결과 출력
    }

    fun earningRate(earningRate: String) {
        println("총 수익률은 ${earningRate}입니다.")
    }

}