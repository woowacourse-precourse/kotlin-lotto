package lotto

import lotto.domain.LottoGame

fun main() {
    try {
        //LottoGame().run()

        val str = "1,2,3,4,"
        val result = str.split(",")
        for(i in result){
            println(i)
        }

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
