package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class functionSet {
    fun inputMoney() : Int{ // 돈 입력
        val money = Console.readLine()
        if (money.toIntOrNull() == null) {
            println("[ERROR] : 로또 구매후 잔액이 존재합니다.") // IllegalArgumentException 사용시 테스트 실패
            System.exit(0)
        }
        return money.toInt()
    }

    fun outputCount(money : Int): Int { // 개수 계산
        val count = money / 1000
        if (money % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] : 로또 구매후 잔액이 존재합니다.")
        }
        return count
    }

    fun outputLotto(count: Int): MutableList<List<Int>> { // 로또 생성
        val lotto = mutableListOf<List<Int>>()
        var lottoNumber : MutableList<Int>
        for (i in 0 until count) {
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lotto.add(lottoNumber)
        }
        return lotto
    }

    fun inputNumber(): MutableList<Int> { // 숫자 입력
        val splitNumber = Console.readLine().split(",")
        val number = mutableListOf<Int>()
        for (i in splitNumber) {
            number.add(i.toInt())
        }
        return  number
    }
    fun inputbonus(): Int { // 보너스 입력
        val bonus = Console.readLine().toInt()
        return  bonus
    }

    fun compareNumbers(lottoCollection : List<Int>, winningNumber: List<Int>, bonusNumber: Int) : Int { // 당첨 확인
        var count = 0
        if (bonusNumber in winningNumber) {
            throw IllegalArgumentException("[ERROR] : 보너스 숫자를 잘못 입력했습니다.")
        }
        for (i in 0 until winningNumber.size){
            if (lottoCollection.contains(winningNumber[i])){
                count += 1
            }
        }
        if (count == 5) {
            if (bonusNumber in lottoCollection) { // 보너스 숫자 맞출시 숫자 7 부여
                count += 2
            }
        }
        return count
    }
}