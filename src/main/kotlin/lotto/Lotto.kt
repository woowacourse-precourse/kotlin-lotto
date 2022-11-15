package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.security.cert.TrustAnchor

class Lotto(private val numbers: List<Int>) {
    private var lottoNumbers = listOf<Int>()
    private var bonusFlag: Boolean = false

    init {
        require(numbers.size == 6)
        this.lottoNumbers = numbers
        this.bonusFlag = false
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

    private fun checkLottery(winlottonum : Lotto, bonusnum: Int) : Int {
        var lottery: Int = 0
        var bonusLottery = false

        val winnum = winlottonum.lottoNumbers
        val checknum = this.lottoNumbers

        winnum.forEach() {it
            lottery += compareWithList(checknum, it)
        }
        if (lottery == 5){
            this.bonusFlag = true
        }
        if(this.bonusFlag){
            bonusLottery = bonusNumCheck(bonusnum)
        }
        return lottery
    }

    private fun compareWithList(checkList: List<Int>, win: Int): Int{
        if (checkList.contains(win)){
            return 1
        }
        else
            return 0
    }

    private fun bonusNumCheck(bonusnum : Int) : Boolean{
        // checks for bonus number
        val checknum = this.lottoNumbers
        var lottery = 0
        checknum.forEach() {it
            lottery += compareWithList(checknum, it)
        }
        return lottery>=1
    }


}



