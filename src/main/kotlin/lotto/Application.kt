package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun makeLotto(): Lotto = try {
    Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
} catch (e: IllegalArgumentException) {
    makeLotto()
}