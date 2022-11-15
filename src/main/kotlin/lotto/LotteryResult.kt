package lotto

enum class LotteryResult(val correct: Int, val cost: String) {
    SIX(6, "2,000,000,000"),
    FIVEANDBONUS(7, "30,000,000"),
    FIVE(5, "1,500,000"),
    FOUR(4, "50,000"),
    THREE(3, "5,000");

    companion object {
        fun printCost(correct: Int) : String{
            return when (correct) {
                THREE.correct -> (" (${THREE.cost}원)")
                FOUR.correct -> (" (${FOUR.cost}원)")
                FIVE.correct -> (" (${FIVE.cost}원)")
                FIVEANDBONUS.correct -> (", 보너스 볼 일치 (${FIVEANDBONUS.cost}원)")
                SIX.correct -> (" (${SIX.cost}원)")
                else -> {throw IllegalArgumentException()}
            }
        }

        fun getCost(correct: Int) : Long{
            return when (correct) {
                THREE.correct -> 5000
                FOUR.correct -> 50000
                FIVE.correct -> 1500000
                FIVEANDBONUS.correct -> 30000000
                SIX.correct -> 2000000000
                else -> {throw IllegalArgumentException()}
            }
        }
    }
}