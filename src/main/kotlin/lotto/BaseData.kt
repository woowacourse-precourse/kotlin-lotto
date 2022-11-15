package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseData {
    var inputMoney = 0
    var purchasedLotto = mutableListOf<MutableList<Int>>()
    var LottoNum = mutableListOf<Int>()
    var bonusNum = 0

    fun baseData(){
        inputMoney()
        buyLotto()
        inputLottoNum()
        inputBonus()
    }

    fun inputMoney() {
        println("구입금앱을 입력해 주세요.")
        val money=Console.readLine()
        validInputMoney(money)
        inputMoney = money.toInt()
    }

    fun validInputMoney(money : String){
        if(money.elementAt(0).code <48 || money.elementAt(0).code>57){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
        }
        if(inputMoney%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.")
        }
    }
    fun countpurchasingVolume(inputMoney: Int): Int {
        val purchasingVolume = inputMoney/1000
        println("${purchasingVolume}개를 구매했습니다.")
        return purchasingVolume
    }

    fun buyLotto() {
        val purchasingVolume = countpurchasingVolume(inputMoney)
        for(i in 1..purchasingVolume){
            purchasedLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            println(purchasedLotto[i-1])
        }
    }

    fun inputLottoNum() {
        println("당첨 번호를 입력해 주세요.")
        val Lotto = Console.readLine()
        makeLottoNum(Lotto)
    }
    fun makeLottoNum(Lotto:String) {
        for(i in Lotto.replace(" ","").split(",")){
            LottoNum.add(i.toInt())
        }
    }
    fun inputBonus() {
        println("보너스 번호를 입력해 주세요.")
        val bonus=Console.readLine()
        validInputBonus(bonus)
        bonusNum = bonus.toInt()
    }
    fun validInputBonus(bonus : String){
        if(bonus.elementAt(0).code<48 || bonus.elementAt(0).code>57){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
        }
        if(bonus.toInt() < 1
            || bonus.toInt() > 45
        ){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

    }
}