package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        try {
            require(numbers.size == 6)
        } catch (e:Exception) {
            throw IllegalArgumentException("[ERROR] 6개만 입력해야 합니다.")
        }
    }

    fun lottoAnswer(answers : List<Int>){
        if(answers.size != (answers.filter{ it in 1..45 }).size){
            throw IllegalArgumentException("[ERROR] 1부터 45 숫자를 입력하셔야 합니다.")
        } else if (answers.size != answers.distinct().size){
            throw IllegalArgumentException("[ERROR] 중복이 없어야 합니다.")
        }
    }
    // TODO: 추가 기능 구현
}
