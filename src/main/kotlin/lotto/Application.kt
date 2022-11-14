package lotto

fun main()  {
    try {
        LottoSimulator.run()
    }catch (e: IllegalArgumentException){
        println(e.message)
        return
    }

}
