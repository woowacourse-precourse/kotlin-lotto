package lotto


class Util {
    fun isNumInt(input: String): Boolean{
        val isNull = input.toIntOrNull()
        if(isNull == null){
            println("${ERROR_MESSAGE} 정수를 입력하지 않으셨습니다.")
            throw IllegalArgumentException("${ERROR_MESSAGE} 정수를 입력하지 않으셨습니다.")
            return false
        }
        return true
    }

    fun isRightForm(input: String) : Boolean{
        val inputSlice = input.split(",")
        if(inputSlice.size!=6){
            throw IllegalArgumentException("$ERROR_MESSAGE 잘못된 양식입니다.")
        }
        for(i in 0..5){
            val num = inputSlice[i].toIntOrNull()
            if(num==null){
                throw IllegalArgumentException("$ERROR_MESSAGE 잘못된 양식입니다.")
            }
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
        if(numList.size != 6){
            throw IllegalArgumentException("$ERROR_MESSAGE 로또 개수가 잘못되었습니다.")
        }

        return true
    }

    fun isRightRange(numList: List<Int>) : Boolean {
        for(i in 0 until numList.size){
            if(numList[i]<1 || numList[i]>45){
                throw IllegalArgumentException("$ERROR_MESSAGE 로또 번호의 범위가 잘못되었습니다.")
            }
        }
        return true
    }

    fun isOverlap(numList: List<Int>) : Boolean {
        if(numList.size != numList.toSet().size){
            throw IllegalArgumentException("$ERROR_MESSAGE 중복된 로또 번호가 존재합니다.")
        }
        return false
    }

    fun checkBonusNum(input:String, lottoNum: Lotto) : Boolean{
        isNumInt(input)
        var bonus = input.toInt()
        isRightRange(listOf(bonus))
        var numbers = lottoNum.getLottoNum().toMutableList<Int>()
        numbers.add(bonus)
        isOverlap(numbers.toList())
        return true
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }

}