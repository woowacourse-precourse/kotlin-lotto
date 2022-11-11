package lotto

fun main() {
    val price = buyLottoPrice()
}

fun buyLottoPrice(): Int {
    println("로또 구입금액을 입력해 주세요.")
    val price = readLine().toString()

    try {
        if (price.toInt() % 1000 != 0) {
            println("[ERROR] 구입 금액은 1,000원 단위입니다.")
            throw IllegalArgumentException()
        }
        return price.toInt()
    } catch (e : NumberFormatException) {
        println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}
