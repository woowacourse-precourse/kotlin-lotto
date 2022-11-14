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

//    fun changeInputToLotto(input:String):List<Int>{
//
//    }

    fun isRightNumCount() {

    }

    fun isRightRange() {

    }

    fun isOverlap() {

    }
}