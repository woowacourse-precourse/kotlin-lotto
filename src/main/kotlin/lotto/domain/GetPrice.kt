package lotto.domain

object GetPrice {

    fun getNum(strPrice: String): Int{
        isInt(strPrice)
        val price = strPrice.toInt()
        isPrice(price)

        return price
    }

    private fun isInt(string: String) {
        string.forEach { char ->
            val charConvertedToCode = char.code
            if(charConvertedToCode < 48 || charConvertedToCode > 57) {
                throw IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.")
            }
        }
    }

    private fun isPrice(number: Int) {
        if(number%1000!=0) {
            throw IllegalArgumentException("[ERROR] 금액은 1000원 단위만 입력 가능합니다.")
        }
    }


}