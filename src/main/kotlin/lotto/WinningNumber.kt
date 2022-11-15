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
    fun MakeListLottoNumber(lotto_numbers: String?): MutableList<Int> {
        val lotto_numbers_list_string= lotto_numbers!!.split(",")
        if (lotto_numbers_list_string.size!=6){ throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.") }
        val lotto_numbers_list= mutableListOf<Int>()
        for (num in 0..5){
            if(lotto_numbers_list_string[num].toInt()<1 || lotto_numbers_list_string[num].toInt()>45){
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.") }
            lotto_numbers_list.add(lotto_numbers_list_string[num].toInt())
        }
        if(lotto_numbers_list.distinct().size!=6){ throw IllegalArgumentException("[ERROR] 중복된 수가 있습니다.") }
        return lotto_numbers_list
    }
}