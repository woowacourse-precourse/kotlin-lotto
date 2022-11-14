package lotto

fun main() {
    try {
        LottoGame().run()
    }catch (e: IllegalArgumentException){
        println(e.message)
    }
}
