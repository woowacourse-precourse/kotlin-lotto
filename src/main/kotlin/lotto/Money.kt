package lotto

class Money{
    fun InputMoney(): String? {
        println("구입금액을 입력해 주세요.")
        val input_buy = readLine()
        return input_buy
    }
    fun InputError(input_buy: String?):Int{
        val buy:Int

        try{
            buy= input_buy!!.toInt()
        }catch (e:NumberFormatException){
            println("[ERROR] 숫자형태로 입력해주세요.")
            throw NoSuchElementException()
        }
        if(buy%1000!=0){
            throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력 하시오.")
        }

        return buy
    }
}