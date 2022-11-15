package lotto

class WinningNumber{
    fun InputLottoNumber(): String? {
        println("당첨 번호를 입력해 주세요.")

        val lotto_numbers=readLine()
        for(i in lotto_numbers!!.toList()){
            if(i.code>=48 && i.code<=57){ continue }
            if(i.code==44){ continue }
            throw IllegalArgumentException("[ERROR] 입력 형식을 다시 확인하세요.")
        }
        return lotto_numbers
    }
}