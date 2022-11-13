package lotto

import org.mockito.internal.matchers.Not
import org.mockito.internal.matchers.Null

class CheckException() {


    fun checkMod(amount: String) {

        if (amount.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요!")
        }

    }

    fun checkInt(amount: String) {

        if (!isNumber(amount)) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요!")
        }
    }

    fun isNumber(string: String): Boolean {
        return !string.isNullOrEmpty() && string.matches(Regex("\\d+"))
    }

    fun checkListSize(numGroup: List<String>) {

        if (numGroup.size != 6) {
            throw IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해 주세요.")
        }
    }

    fun checkRange(numGroup: List<String>) {
        for (i in 0 until numGroup.size) {
            if (numGroup[i].toInt() < 1 || numGroup[i].toInt() > 45) {
                throw IllegalArgumentException("[ERROR] 1~45사이의 숫자를 입력해 주세요.")
            }
        }
    }

    fun checkDuplicate(numGroup: List<String>) {

        if (numGroup.size != numGroup.distinct().count()) {
            throw IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 숫자로 입력해 주세요.")
        }
    }

    fun checkBonusNum(num : String , numGroup: List<String>){

        if(numGroup.contains(num)){
            throw IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호입니다.")
        }
    }

}