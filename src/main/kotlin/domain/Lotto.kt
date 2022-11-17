package domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(numbers.distinct().size==6){"[ERROR] : 숫자가 중복되어 있습니다."}
        require(numbers.all { it in 1..45 }){"[ERROR] : 숫자는 1~45 사이어야 합니다."}
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
