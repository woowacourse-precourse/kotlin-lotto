package lotto

import lotto.ui.MainView

fun main() {
//    TODO("프로그램 구현")
    val userMainView = MainView()
    LottoStart(userMainView).calcWinPrice()
}