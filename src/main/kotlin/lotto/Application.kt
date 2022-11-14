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
    val bonusNumber = inputBonus()
    val countReward = calculateSame(lottoNumber,winningNumber,bonusNumber)
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

fun inputBonus(): Int {
    getMessage(Message.BONUS)
    val bonusNumber = readLine()
    return bonusNumber!!.toInt()
}

fun calculateSame(lottoNumber: MutableList<MutableList<Int>>, winningNumber:  List<Int>, bonusNumber: Int): MutableList<Int> {
    var countReward: MutableList<Int> = mutableListOf(0,0,0,0,0)
    for(i:Int in lottoNumber.indices){
        val difference = winningNumber.toSet().minus(lottoNumber[i].toSet())
        val duplicationCount = winningNumber.size - difference.size
        print(duplicationCount)
        val countWinning = calculateReward(duplicationCount,bonusNumber,winningNumber)
        for(i in 0 until countReward.size){
            countReward[i] = countReward[i] + countWinning[i]
        }
    }
    println(countReward)
    return countReward
}

fun calculateReward(duplicationCount: Int, bonusNumber:Int, winningNumber: List<Int>): MutableList<Int> {
    val countReward:MutableList<Int> = mutableListOf(0,0,0,0,0)
    when(duplicationCount){
        3 -> countReward[0]=+1
        4 -> countReward[1]=+1
        5 -> whenCountFive(countReward, bonusNumber, winningNumber)
        6 -> countReward[4]+=1
    }
    return countReward
}

fun whenCountFive(countReward: MutableList<Int>, bonusNumber: Int, winningNumber: List<Int>): MutableList<Int> {
    if(winningNumber.contains(bonusNumber)){
        countReward[3] =+ 1
        return countReward
    }
    countReward[2] =+ 1
    return  countReward
}

fun calculateMoney(countReward: MutableList<Int>): Int {
    var money:Int = 0
    for(index:Int in 0 until countReward.size) {
        when (index) {
            0 -> money += countReward[0] * 5000
            1 -> money += countReward[1] * 50000
            2 -> money += countReward[2] * 1500000
            3 -> money += countReward[3] * 30000000
            4 -> money += countReward[4] * 2000000000
        }
    }
    return money
}