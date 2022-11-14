package lotto

class Calculator {
    fun compareLottoNum(lottoNum:List<List<Int>>, lotto:Lotto, bonus: Int): List<Int>{
        var score = listOf<Int>(0,0,0,0)
        for(i in 0 until lottoNum.size){
            val result = checLotto(lottoNum[i], lotto, bonus)
            when(result){
                Answer.THREE-> score[0].plus(1)
                Answer.FOUR->score[1].plus(1)
                Answer.FIVE->score[2].plus(1)
                Answer.SIX->score[3].plus(1)
                else->continue
            }
        }
        return score
    }
    fun checLotto(lottoNum:List<Int>, lotto:Lotto, bonus: Int) : Answer{

    }
}