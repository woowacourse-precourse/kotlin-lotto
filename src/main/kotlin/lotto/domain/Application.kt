package lotto.domain


fun main() {
    val generator = NumberGenerator()
    val numbers = generator.createLottoNumber()
    println(numbers)
}

