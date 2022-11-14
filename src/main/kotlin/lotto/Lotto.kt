package lotto

import camp.nextstep.edu.missionutils.Randoms

// private 최상위에서 이용할때 : 파일 내부에서만 이용
// private 클래스 멤버에서 이용할때 : 클래스 내부에서만 이용
open class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

}

class LottoGames: Lotto {
    constructor(numbers: List<Int>): super(numbers){

    }
    fun pickLottoNumbers() : MutableList<Int> {
        val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumber.sort()
        return lottoNumber
    }

    fun compareNumbers(lottoCollection : List<Int>, winningNumber: List<Int>) : Int {
        var count = 0
        for (i in 0 until winningNumber.size){
            if (lottoCollection.contains(winningNumber[i])){
                count+=1
            }
        }
        return count
    }
}