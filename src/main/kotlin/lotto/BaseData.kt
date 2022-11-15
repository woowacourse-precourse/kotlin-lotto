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
        for(i in 0 until money.length){
            if(money.elementAt(i).code <48 || money.elementAt(i).code>57){
                throw IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.")
            }
        }
        if(money.toInt()%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.")
        }
        if(money.toInt()<1000) {
            throw IllegalArgumentException("[ERROR] 구입금액은 1000원 이상입니다.")
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
        val lotto = Console.readLine()
        validInputLotto(lotto)
        makeLottoNum(lotto)
    }
    fun makeLottoNum(lotto:String) {
        for(i in lotto.replace(" ","").split(",")){
            LottoNum.add(i.toInt())
        }
    }
    fun validInputLotto(lotto : String){
        for(i in 0 until lotto.length step 2){
            if(lotto.elementAt(i).code <48 || lotto.elementAt(i).code>57){
                throw IllegalArgumentException("[ERROR] 로또번호는 숫자여야 합니다.")
            }
        }
        for(i in 1 until lotto.length step 2){
            if(lotto.elementAt(i)!=','){
                print(lotto.elementAt(i))
                throw IllegalArgumentException("[ERROR] 로또번호는 ,로 구분해야 합니다.")
            }
        }
    }
    fun inputBonus() {
        println("보너스 번호를 입력해 주세요.")
        val bonus=Console.readLine()
        validInputBonus(bonus)
        bonusNum = bonus.toInt()
    }
    fun validInputBonus(bonus : String){
        for(i in 0 until bonus.length){
            if(bonus.elementAt(i).code <48 || bonus.elementAt(i).code>57){
                print("[ERROR]")
                throw IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.")
            }
        }
        if(bonus.toInt() < 1
            || bonus.toInt() > 45
        ){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

    }
}