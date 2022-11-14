package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR] : 숫자가 6개가 아닙니다."}
        require(numbers.distinct().size==6){"[ERROR] : 중복된 숫자가 있습니다"}
    }
    fun inputBonusNum(winNum:List<String>):Int{
        println("보너스 번호를 입력해 주세요.")
        var remainder = (1..45).toMutableList()
        for(i in winNum) {
            if (remainder.contains(i.toInt()))
                remainder.remove(i.toInt())
        }
        var ret :String = Console.readLine()
        require(ret.isNotEmpty()){"[ERROR] 값을 입력해야 합니다."}
        require(ret.all{it.isDigit()}){"[ERROR] 숫자만 입력해야 합니다."}
        require(remainder.contains(ret.toInt())){"[ERROR] : 올바른 숫자가 아닙니다."}
        return ret.toInt()
    }

}
