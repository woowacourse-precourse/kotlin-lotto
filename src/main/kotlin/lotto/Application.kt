package lotto

fun main() {
    Lottery(
        Computer(),
        Calculator(),
        Buyer(),
        Printer()
    ).start()
}
