package lotto

fun main()  {
    val customer = Customer()
    try {
        val input = customer.getInputMoney()
    }catch (e: IllegalArgumentException){
        println(e.message)
        return
    }

}
