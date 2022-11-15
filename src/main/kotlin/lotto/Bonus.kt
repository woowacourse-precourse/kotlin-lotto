package lotto

class Bonus (private val bonus: Int){
    init{
        if(bonus <= 0||bonus>=10) throw IllegalArgumentException()
    }
}