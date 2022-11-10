package lotto

class Consumer(private val money: Int) {
    init {
        require(money % 1000 == 0) { println("[ERROR] 1000원 단위가 아닙니다.") }
        require(money >= 1000) { println("[ERROR] 돈이 부족합니다") }
    }
}