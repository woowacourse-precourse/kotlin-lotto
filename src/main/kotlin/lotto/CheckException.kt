package lotto

import lotto.model.Number
import lotto.model.Strings
import org.mockito.internal.matchers.Not
import org.mockito.internal.matchers.Null

class CheckException() {

    fun checkInput(amount: String) {
        checkInt(amount)
        checkMod(amount)
    }

    fun checkMod(amount: String) {

        if (amount.toInt() % Number.Cost.value != 0) {
            throw IllegalArgumentException(Strings.Input_1000_Unit.reward)
        }

    }

    fun checkInt(amount: String) {

        if (!isNumber(amount)) {
            throw IllegalArgumentException(Strings.Input_Only_Num.reward)
        }
    }

    fun isNumber(string: String): Boolean {
        return !string.isNullOrEmpty() && string.matches(Regex("\\d+"))
    }

    fun checkLottoGroup(numGroup: List<Int>) {
        checkListSize(numGroup)
        checkRange(numGroup)
        checkDuplicate(numGroup)
    }

    fun checkListSize(numGroup: List<Int>) {

        if (numGroup.size != 6) {
            throw IllegalArgumentException(Strings.Input_Six_WinningNum.reward)
        }
    }

    fun checkRange(numGroup: List<Int>) {
        for (i in 0 until numGroup.size) {
            if (numGroup[i].toInt() < 1 || numGroup[i].toInt() > 45) {
                throw IllegalArgumentException(Strings.Input_Correct_Range.reward)
            }
        }
    }

    fun checkDuplicate(numGroup: List<Int>) {

        if (numGroup.size != numGroup.distinct().count()) {
            throw IllegalArgumentException(Strings.Input_EachOther_Num.reward)
        }
    }

    fun checkBonusNum(num: Int, numGroup: List<Int>) {

        if (numGroup.contains(num)) {
            throw IllegalArgumentException(Strings.This_Duplicate_Num.reward)
        }
    }

}