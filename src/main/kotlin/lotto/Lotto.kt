package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        if(numbers.size!=6){
            throw IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다")
        }
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
    fun game(answer:Array<Int>,bonusNumber:Int):Int{
        //정식번호 맞은 개수
        var sameCnt = 7
        answer.forEach{
            if(numbers.contains(it)){
                sameCnt--;
            }
        }
        return sameCnt

    }

    override fun toString(): String {
        return numbers.toString()
    }
}

