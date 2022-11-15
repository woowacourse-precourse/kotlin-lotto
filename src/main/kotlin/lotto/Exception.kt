package lotto

class ExceptionMessage {
    companion object {
        const val illegalErrorMessage = "[ERROR] 잘못된 값을 입력하였습니다."
        const val nullErrorMessage = "[ERROR] 로또는 한 장 이상 사야합니다."
        const val relateNumberMessage = "[ERROR] 중복된 숫자를 입력하실 수 없습니다."
        const val rangeErrorMessage = "[ERROR] 1~45사이의 숫자만 입력하실 수 있습니다."
        const val sizeErrorMessage = "[ERROR] 6가지의 수를 입력하십시오."
        const val sameNumErrorMessage = "[ERROR] 보너스 번호는 당첨 번호와 일치할 수 없습니다."
    }
}