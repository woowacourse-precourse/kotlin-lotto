package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현

    override fun toString(): String {
        // function to make class Lotto to String
        // - to print out -
        var string = "["
        this.numbers
        for (i in 0 until 5){
            string += this.numbers[i].toString() + ", "
        }

        return string + this.numbers[5].toString() + "]"
    }

    private fun printOneLotto(){
        println(this.toString())
    }
    fun createOneLotto() : Lotto {
        // 새로운 랜덤한 로또 용지 하나를 만드는 함수

        var newLotto = mutableSetOf<Int>()
        while (newLotto.size < 6)
            newLotto+= Randoms.pickNumberInRange(1, 9)
        return ListToLotto(newLotto.toList())
    }

    fun ListToLotto(lottoInList: List<Int>) : Lotto {
        return Lotto(lottoInList)
    }

    fun createLottoList(howMany : Int) : List<Lotto>{
        // 로또 용지의 전체 리스트를 리턴함
        var newLottoList: List<Lotto> = listOf<Lotto>()

        for(i: Int in 0 until  howMany){
            val aLotto= createOneLotto()
            newLottoList += aLotto
        }
        return newLottoList
    }

}


