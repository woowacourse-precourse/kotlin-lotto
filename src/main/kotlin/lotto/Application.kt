package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

fun main() {
    var emd1 = 0
    var emd2 = 0
    var emd3 = 0
    var emd4 = 0
    var emd5 = 0
    var moneyResult = 0

    println("구입금액을 입력해 주세요.")
    var moneyInput = Console.readLine()
    var moneyCount = Money(moneyInput)
    println("${moneyCount.run()}개를 구매했습니다.")
    var randomlotto = makeRandomLotto(moneyCount.run())

    println("당첨 번호를 입력해 주세요.")
    var myNumber = Console.readLine()
    var myList = myNumber!!.split(',').map { it.toInt() }.toList()
    Lotto(myList)

    println("보너스 번호를 입력해 주세요.")
    var bonusNumber = Console.readLine()
    if (bonusNumber!!.toInt() !in (1..45) )
        throw IllegalArgumentException("[ERROR] : 올바른 범위의 숫자를 입력해 주세요.(1~45)")
    if (myList.contains(bonusNumber.toInt()))
        throw IllegalArgumentException("[ERROR] : 입력한 당첨 번호와 중복됩니다.")

    println("당첨 통계")
    for (i in 0 until randomlotto.size){
        val union = randomlotto[i]+myList
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        if(intersection.size == 3){
            emd5+=1
            moneyResult+=5000
        }
        if(intersection.size == 4){
            emd4+=1
            moneyResult+=500000
        }
        if(!(randomlotto[i].contains(bonusNumber.toInt()))&&intersection.size == 5){
            emd3+=1
            moneyResult+=1500000
        }
        if(randomlotto[i].contains(bonusNumber.toInt())&&intersection.size == 5){
            emd2+=1
            moneyResult+=30000000
        }
        if(intersection.size == 6){
            moneyResult+=2000000000
            emd1+=1
        }
    }

    println("3개 일치 (5,000원) - ${emd5}개")
    println("4개 일치 (50,000원) - ${emd4}개")
    println("5개 일치 (1,500,000원) - ${emd3}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${emd2}개")
    println("6개 일치 (2,000,000,000원) - ${emd1}개")
    println("총 수익률은 ${round(moneyResult/moneyInput.toFloat()*1000) /10}%입니다.")
}

fun makeRandomLotto(count:Int): MutableList<List<Int>> {
    var lottolist = mutableListOf<List<Int>>()
    for (i in 1..count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        lottolist.add(numbers)
        println(numbers)
    }
    return lottolist
}