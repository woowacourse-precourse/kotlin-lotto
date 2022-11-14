package lotto

class WinningPrinter(private val winningList: List<Int>) {
    fun printWinning() {
        println("당첨 통계")
        println("---")
        for (rank in 5 downTo 1) {
            printWinningList(rank)
        }
    }

    private fun printWinningList(rank: Int) {
        when(rank) {
            5 -> println("3개 일치 (5,000원) - ${winningList[rank]}개")
            4 -> println("4개 일치 (50,000원) - ${winningList[rank]}개")
            3 -> println("5개 일치 (1,500,000원) - ${winningList[rank]}개")
            2 -> println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningList[rank]}개")
            1 -> println("6개 일치 (2,000,000,000원) - ${winningList[rank]}개")
        }
    }
}