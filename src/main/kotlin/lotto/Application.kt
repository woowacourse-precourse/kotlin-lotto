package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val price = inputPrice()
    val lottoCount = calculatePrice(price)
    val lottoNumber = pickNumber(lottoCount)
    printNumbers(lottoNumber,lottoCount)
    val winning = inputWinning()
    val winningNumber = changeNumberList(winning)
    Lotto(winningNumber)

}

enum class Message {
    PRICE, COUNT, NUMBER, BONUS,
}

fun getMessage(message: Message) {
    when (message) {
        Message.PRICE -> println("구입금액을 입력해 주세요.")
        Message.COUNT -> println("개를 구매했습니다.")
        Message.NUMBER -> println("당첨 번호를 입력해 주세요.")
        Message.BONUS -> println("보너스 번호를 입력해 주세요.")
    }
}

fun inputPrice(): Int {
    getMessage(Message.PRICE)
    return readLine()!!.toInt()
}

fun calculatePrice(price: Int): Int {
    if (price % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.")
    }
    return price / 1000
}

fun pickNumber(lottoCount: Int): MutableList<MutableList<Int>> {
    val lottoNumber:MutableList<MutableList<Int>> = mutableListOf()

    for(number:Int in 0 until lottoCount){
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        randomNumbers.sort()
        lottoNumber.add(randomNumbers)
    }
    return lottoNumber
}

fun printNumbers(lottoNumber: MutableList<MutableList<Int>>, lottoCount: Int){
    print(lottoCount)
    getMessage(Message.COUNT)
    for(count in 0 until lottoCount){
        println(lottoNumber[count])
    }
}

fun inputWinning(): String {
    getMessage(Message.NUMBER)
    val winning = readLine()
    return winning.toString()
}

fun changeNumberList(winning: String): List<Int> {
    val winningNumber = winning.split(',').map{it.toInt()}
    print(winningNumber)
    return winningNumber
}
