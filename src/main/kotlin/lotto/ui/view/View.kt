package lotto.ui.view

import lotto.domain.common.ErrorType


abstract class View {
    open fun printErrorMessage(errorType: ErrorType) {
        if (errorType != ErrorType.NORMAL) {
            println(errorType.errorMessage)
            throw java.lang.IllegalArgumentException()
        }
    }
}
