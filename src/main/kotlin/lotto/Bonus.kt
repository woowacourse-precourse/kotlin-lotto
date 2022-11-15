package lotto

class Bonus{
    fun InputBonus():Int{
        println("보너스 번호를 입력해 주세요.")
        val bonus = readLine()!!.toInt()
        if(bonus<1 || bonus>45){
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return bonus
    }
}