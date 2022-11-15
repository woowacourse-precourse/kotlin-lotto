package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printLotto(){
        println(numbers)
    }

    fun winLottoCheck(lottoNum : MutableList<Int>,bonusNum : Int) : Int{
        var matchCount : Int = 0
        for(i : Int in 0..5){
            matchCount += lottoCheck(i, lottoNum)
        }
        if(matchCount == 5 && bonusCheck(bonusNum))
            return 7
        return matchCount

    }

    fun lottoCheck(num : Int, lottoNum : MutableList<Int>) : Int {
        for(i : Int in 0..5){
            if(numbers[num] == lottoNum[i])
                return 1
        }
        return 0
    }

    fun bonusCheck(bonusNum : Int ) : Boolean{
        for(i : Int in 0..5)
            if(numbers[i]==bonusNum)
                return true
        return false
    }
}
