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
    fun printNumber(){
        println(numbers.sorted())
    }

    override fun toString(): String {
        return numbers.toString()
    }
    
    //랭킹
    fun rank(solution:List<Int>,bonus:Int):Int{
        val sameCnt = sameCount(solution)
        if(sameCnt==6) return 1
        if(sameCnt==5&&numbers.contains(bonus)) return 2
        if(sameCnt==5) return 3
        if(sameCnt==4) return 4
        if(sameCnt==3) return 5
        return -1
    }
    //일반번호 동일 갯수
    fun sameCount(solution:List<Int>):Int{
        var count=0
        for(i in solution){if(numbers.contains(i)){count++}}
        return count

    }
}

