package lotto

class BonusNumber {

    init {
        println("보너스 번호를 입력해 주세요.")
    }

    fun bonusnumber (a:IntArray) : Int {
        var bonusnumber = readLine()!!.toInt()
        for (i in 0..5)
        {
            if (bonusnumber == a[i])
            {
                throw IllegalArgumentException("[ERROR] 기존 번호와 보너스 번호가 같습니다.")
            }
        }
        if (bonusnumber > 45 || bonusnumber < 1)
        {
            throw IllegalArgumentException("[ERROR] 값은 1부터 45까지 입니다.")
        }
        return bonusnumber
    }
}