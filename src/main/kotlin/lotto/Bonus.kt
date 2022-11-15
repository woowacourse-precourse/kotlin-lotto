package lotto

class Bonus (userNumberInt:List<Int>,private val bonus: Int){
    init{
        if(bonus <= 0) throw IllegalArgumentException()

        for(i in 0 until 6){
            if(userNumberInt[i] == bonus) throw IllegalArgumentException()
        }
    }
}