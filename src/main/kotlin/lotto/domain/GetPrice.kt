package lotto.domain

object GetPrice {

    fun getNum(strPrice: String): Int{
        isInt(strPrice)
        val price = strPrice.toInt()
        isPrice(price)

        return price
    }

    fun count(number: Int): Int {
        return number/1000
    }

    private fun isInt(string: String) {
        string.forEach { char ->
            val charConvertedToCode = char.code
            if(charConvertedToCode < 48 || charConvertedToCode > 57) {
                print("[ERROR] 금액은 숫자만 입력 가능합니다.")
                throw NoSuchElementException()
            }
        }
    }

    private fun isPrice(number: Int) {
        if(number%1000!=0) {
            print("[ERROR] 금액은 1000원 단위만 입력 가능합니다.")
            throw NoSuchElementException()
        }
    }


}