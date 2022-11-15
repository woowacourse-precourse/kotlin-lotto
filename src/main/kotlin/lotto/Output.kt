package lotto

class Output {
    companion object {
        fun printNumbers(lottoNumber: MutableList<MutableList<Int>>, lottoCount: Int) {
            print(lottoCount)
            getMessage(Message.COUNT)
            for (count in 0 until lottoCount) {
                println(lottoNumber[count])
            }
        }

        fun printReward(countReward: MutableList<Int>, revenue: Float) {
            println("당첨 통계\n" +
                    "---\n" +
                    "3개 일치 (5,000원) - " + countReward[0] + "개\n" +
                    "4개 일치 (50,000원) - " + countReward[1] + "개\n" +
                    "5개 일치 (1,500,000원) - " + countReward[2] + "개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - " + countReward[3] + "개\n" +
                    "6개 일치 (2,000,000,000원) - " + countReward[4] + "개\n")
            print("총 수익률은 %.1f".format(revenue))
            print("%입니다.")
        }
    }

}