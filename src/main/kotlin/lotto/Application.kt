package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

fun inputLottoPrice() : Int{
    val price = Console.readLine()
    return try {
        Integer.parseInt(price)
    } catch (e: IllegalArgumentException) {
        Error.typeError()
        -1
    }
}

fun printLottoCount(count: Int) {
    println("${count}개를 구매했습니다.")
}

fun inputWinningLotto(): List<Int> {
    val numbers = Console.readLine().split(",")
    val convertNumbers: MutableList<Int> = mutableListOf<Int>()
    try {
        for(i in numbers.indices) {
            convertNumbers.add(Integer.parseInt(numbers[i]))
        }
        if (convertNumbers.size != 6) throw IllegalArgumentException("size")
    } catch (e: IllegalArgumentException) {
        if(e.message == "size") {
            Error.sizeError()
        } else {
            Error.typeError()
        }
        return listOf()
    }
    return convertNumbers
}

fun inputBonusNumber(): Int {
    return try {
        val bonusNumber = Integer.parseInt(Console.readLine())
        if (bonusNumber > 45 || bonusNumber < 1) throw IllegalArgumentException("range")
        bonusNumber
    } catch(e: IllegalArgumentException) {
        if(e.message == "range") {
            Error.rangeError()
        } else {
            Error.typeError()
        }
        -1
    }
}

fun printWinningResult(winningResult: Map<WinningType, Int>, rate: Double) {
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${winningResult[WinningType.FIFTH]}개")
    println("4개 일치 (50,000원) - ${winningResult[WinningType.FOURTH]}개")
    println("5개 일치 (1,500,000원) - ${winningResult[WinningType.THIRD]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult[WinningType.SECOND]}개")
    println("6개 일치 (2,000,000,000원) - ${winningResult[WinningType.FIRST]}개")
    println("총 수익률은 ${rate}%입니다.")
}

fun main() {
    println("구입금액을 입력해 주세요.")
    val price:Int = inputLottoPrice()
    if (price == -1) return
    val count = LottoCalculator.calculateLottoCount(price)
    printLottoCount(count)
    val lottos = LottoCreator.createRandomLottos(count)
    lottos.printLottos()
    println("\n당첨 번호를 입력해 주세요.")
    val winningNumbers = inputWinningLotto()
    if (winningNumbers.isEmpty()) return
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = inputBonusNumber()
    if (bonusNumber == -1) return
    val winningResult = lottos.matchLottos(winningNumbers, bonusNumber)
    val rate = LottoCalculator.calculateRate(price, winningResult)
    printWinningResult(winningResult, rate)
}
