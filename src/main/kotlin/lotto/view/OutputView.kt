package lotto.view

import lotto.domain.Lotto

private enum class OutputMessage(val message: String) {
    LOTTO_COUNT("개를 구매했습니다."),
    LOTTO_RESULT("당첨 통계\n---"),
    FIFTH_PLACE("3개 일치 (5,000원) - "),
    FOURTH_PLACE("4개 일치 (50,000원) - "),
    THIRD_PLACE("5개 일치 (1,500,000원) - "),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - "),
    YIELD("총 수익률은 "),
    PROGRAM_END("예외가 발생하여 프로그램을 종료합니다.");

    fun getLottoCountMessage(number: Int): String {
        return number.toString() + this.message
    }
}

object OutputView {

    fun printLottoCountMessage(count: Int) {
        println(OutputMessage.LOTTO_COUNT.getLottoCountMessage(count))
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
        println()
    }

}
