package lotto

import java.lang.IllegalArgumentException

class Util {
    fun isNumInt(input: String): Boolean{
        val isNull = input.toIntOrNull()
        if(isNull == null){
            throw IllegalArgumentException("[ERROR] 정수를 입력하지 않으셨습니다.")
        }
        return true
    }

    fun isRightForm(input: String) : Boolean{
        val inputSlice = input.split(",")
        if(inputSlice.size!=6)
            throw IllegalArgumentException("[ERROR] 잘못된 양식입니다.")
        for(i in 0..5){
            val num = inputSlice[i].toIntOrNull()
            if(num==null)
                throw IllegalArgumentException("[ERROR] 잘못된 양식입니다.")
        }
        return true
    }

    fun changeInputToLotto(input:String):List<Int>{
        val inputSlice = input.split(",")
        var lottoNum = mutableListOf<Int>()
        for (i in 0..5){
            lottoNum.add(inputSlice[i].toInt())
        }
        return lottoNum.toList()
    }

    fun isRightNumCount(numList : List<Int>) : Boolean {
        if(numList.size != 6)
            throw IllegalArgumentException("[ERROR] 로또 개수가 잘못되었습니다.")
        return true
    }

    fun isRightRange(numList: List<Int>) : Boolean {
        for(i in 0 until numList.size){
            if(numList[i]<1 || numList[i]>45){
                throw IllegalArgumentException("[ERROR] 로또 번호의 범위가 잘못되었습니다.")
            }
        }
        return true
    }

    fun isOverlap() {

    }
}