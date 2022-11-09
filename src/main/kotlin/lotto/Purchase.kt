package lotto

class Purchase(price: String?) {
    val price : Int
    val count : Int
    init{
        exceptionTest(price)
        this.price = price!!.toInt()
        this.count = this.price/1000
    }

    private fun exceptionTest(price : String?){
        require(!price.isNullOrEmpty()){
            println(ERROR_NO_INPUT)
            throw IllegalArgumentException(ERROR_NO_INPUT)
        }
        val regex = "[0-9]+".toRegex()
        require(price.matches(regex)){
            println(ERROR_NOT_INT)
            throw IllegalArgumentException(ERROR_NOT_INT)
        }
        require(price.toInt()%1000==0){
            println(ERROR_1000UNIT)
            throw IllegalArgumentException(ERROR_1000UNIT)
        }
    }

    companion object{
        fun inputPrice(): String? {
            println("구입금액을 입력해 주세요.")
            return readLine()
        }
    }
}