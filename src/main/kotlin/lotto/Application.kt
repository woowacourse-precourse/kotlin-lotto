package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")
    val machine = LottoMachine(Console.readLine())
    machine.pickNewLotto(machine.getLottoCount())
    println("\n${machine.getLottoCount()}개를 구매했습니다.")
    machine.getLottoNumbers()



}