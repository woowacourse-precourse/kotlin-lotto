package lotto

fun main() {
//    TODO("프로그램 구현")
    try {
        LottoGame().gameControl()
    }catch (e : IllegalArgumentException) {
        println(e.message)
    }
}
