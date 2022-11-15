package domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // (맞춘 로또 개수, 보너스 번호 맞췄는지)
    fun checkLotto(correctLotto:List<Int>, bonus:Int): Pair<Int, Boolean>{
        var winningRes = 0
        var isBonus = false
        for (lottoIdx in correctLotto){
            if (lottoIdx in numbers) winningRes+=1
        }
        if (bonus in numbers) isBonus = true

        return Pair(winningRes, isBonus)
    }



}
