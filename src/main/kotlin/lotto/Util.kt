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

    fun isRightForm(input: String){

    }

    fun changeInputToLotto(input:String):List<Int>{

    }

    fun isRightNumCount() {

    }

    fun isRightRange() {

    }

    fun isOverlap() {

    }
}