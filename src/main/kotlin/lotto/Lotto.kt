package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] 잘못된 번호 생성입니다.."}
        for(i in 1..numbers.size-1){
            if(numbers[i-1]==numbers[i]) throw IllegalArgumentException("[ERROR]중복된 값이 있습니다.")
        }
        numbers.forEach{
            if(it>45 || it <1) throw java.lang.IllegalArgumentException("[ERROR]범위를 초과한 값입니다.")
        }
    }
    fun getter(): List<Int>{
        return this.numbers
    }
    companion object{
        fun newLotto(): Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }
}
