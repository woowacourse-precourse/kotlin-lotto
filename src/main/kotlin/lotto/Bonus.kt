package lotto

class Bonus (private val bonus: Int){
    init{
        if(bonus <= 0) throw IllegalArgumentException()
    }
}