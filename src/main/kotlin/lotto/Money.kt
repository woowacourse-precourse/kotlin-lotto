package lotto

class Money (money: Int){
    private val money : Int

    init {
        this.money = money
        if (money%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 잘못된 입력입니다.")
        }
    }

    fun countLotto(): Int {
        return (money/1000)
    }

    fun getMoney(): Int {
        return money
    }
}