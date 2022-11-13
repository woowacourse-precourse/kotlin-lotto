package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6자리의 숫자여야 합니다." }
        require(numbers == numbers.distinct()) { "[ERROR] 로또 번호는 중복이 없어야 합니다." }
    }

    companion object {
        fun messagetogivemoney() {
            println("구입금액을 입력해 주세요.")
        }
        fun lottocheck(usernumbers: List<Int>, computernumber: List<Int>): Int {
            return usernumbers.intersect(computernumber.toSet()).size
        }
        fun printcount(count: Int) {
            println("$count" + "개를 구매했습니다.")
        }
        fun printlottolist(lottos:List<List<Int>>) {
            for (element in lottos) {
                println(element)
            }
        }

        fun messagetogiveuserlotto() {
            println("당첨 번호를 입력해 주세요.")
        }

        fun messagetogiveuserbonus() {
            println("보너스 번호를 입력해 주세요.")
        }


        fun printprize(checkprize:List<Int>) {
            println("당첨 통계")
            println("---")
            println("3개 일치 (5,000원) - ${checkprize[0]}개")
            println("4개 일치 (50,000원) - ${checkprize[1]}개")
            println("5개 일치 (1,500,000원) - ${checkprize[2]}개")
            println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${checkprize[3]}개")
            println("6개 일치 (2,000,000,000원) - ${checkprize[4]}개")
        }
        fun printyield(lottoyield:Double) {
            println("총 수익률은 " + String.format("%.1f", lottoyield) + "%입니다.")

        }


    }
}
