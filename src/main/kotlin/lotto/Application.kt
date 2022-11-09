package lotto

import camp.nextstep.edu.missionutils.Randoms

fun randomLotto():List<Int> {       //사용자가 로또를 사면 구매한 로또 번호를 반환하는 함수
    var numbers = Randoms.pickUniqueNumbersInRange(1,45,6)
    numbers.sort()

    return numbers
}
fun main() {
    TODO("프로그램 구현")
}