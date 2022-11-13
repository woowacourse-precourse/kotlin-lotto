package lotto

class LottoPrinter {
    fun printLotto(lotto: List<List<Int>>) {
        println("${lotto.size}개를 구매했습니다.")
        for (i in lotto.indices) {
            println(lotto[i])
        }
    }
}