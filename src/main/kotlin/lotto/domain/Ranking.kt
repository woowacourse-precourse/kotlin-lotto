package lotto.domain

class Ranking {
    fun checkRanking(winning:Int,bonus:Boolean):Int{
        when (winning) {
            6 -> return 1
            5 -> return if (bonus) 2 else 3
            4 -> return 4
            3 -> return 5
        }
        return 0
    }
}