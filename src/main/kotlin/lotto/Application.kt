package lotto

fun main() {
    val price = buyLottoPrice()
}

fun buyLottoPrice(): Int {
    println("구입금액을 입력해 주세요.")
    val price = readLine().toString()

    try {
        return price.toInt()
    } catch (e : NumberFormatException) {
        println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}
