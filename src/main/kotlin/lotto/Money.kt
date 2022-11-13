package lotto

class Money (){
    private var money : Int = 0

    constructor(money: Int) : this() {
        this.money = money
        if (money%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        }
    }

    fun getMoney(): Int {
        return money
    }

}