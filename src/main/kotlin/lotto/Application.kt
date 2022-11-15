package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun moneyValidCheck(a : String) : Int {
    val money : Int
    try{
        money = a.toInt()
    }catch(e : NumberFormatException){
        throw IllegalArgumentException("[ERROR] 제대로 된 형태의 숫자를 입력해 주세요")
    }
    if(money < 1000)
        throw IllegalArgumentException ("[ERROR] 숫자가 1000보다 작습니다.")
    if(money%1000 != 0)
        throw IllegalArgumentException("[ERROR] 숫자가 1000으로 나누어 떨어지지 않습니다.")
    return money
}

fun lottoMaker(lottoCount : Int) : MutableList<Lotto>{
    var lottoPack : MutableList<Lotto> = mutableListOf()
    for(i : Int in 1..lottoCount){
        lottoPack.add(Lotto(Randoms.pickUniqueNumbersInRange(1,45,6).sorted()))
        lottoPack[i-1].printLotto()
    }
    return lottoPack
}

fun lottoNumberValidCheck(a : CharArray) : CharArray{
    var check : Int
    for(i : Int in 0..a.size-1){
        check = Character.getNumericValue(a[i])
        if(check < -1 || check >9)
            throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요")
        if(check == -1 && a[i] != ',')
            throw IllegalArgumentException("[ERROR] 적절하지 않은 입력 값이 있습니다")
    }
    return a
}

fun lottoZeroCheck(a : CharArray) : CharArray{
    var beforecheck : Int
    var check : Int
    var nextcheck : Int
    for(i : Int in 0..a.size-3){
        beforecheck = Character.getNumericValue(a[i])
        check = Character.getNumericValue(a[i+1])
        nextcheck = Character.getNumericValue(a[i+2])
        if(beforecheck == -1 && check == 0 && nextcheck == -1)
            throw IllegalArgumentException("[ERROR] 0은 당첨번호가 될 수 없습니다.")
    }
    return a
}

fun lottoCommaCheck(a : CharArray) : CharArray{
    var check : Int
    var nextcheck : Int
    for(i : Int in 0..a.size-2){
        check = Character.getNumericValue(a[i])
        nextcheck = Character.getNumericValue(a[i+1])
        if(check == nextcheck && check == -1)
            throw IllegalArgumentException("[ERROR] ,가 연속적으로 입력되었습니다. 제대로 입력해 주세요")
    }
    return a
}

fun lottoLastNumberCheck(a : CharArray) : CharArray{
    if(Character.getNumericValue(a[a.size-1]) == -1){
        throw IllegalArgumentException("[ERROR] 마지막 값은 숫자여야 합니다.")
    }
    return a
}

fun toIntegerList(a : CharArray) : MutableList<Int>{
    var lottoNumbers : MutableList<Int> = mutableListOf()
    var i = 0
    if(a.size<11)
        throw IllegalArgumentException("[ERROR] 입력값이 너무 적습니다.2312")
    do{
        i = makeInteger(i,a, lottoNumbers)
    }while(lottoNumbers.size <6)

    return lottoNumbers
}

fun lottoSizeCheck(a : MutableList<Int>):MutableList<Int>{
    if(a.size !=6 ){
        throw IllegalArgumentException("[ERROR] 6개의 숫자가 입력되지 않았습니다.")
    }
    return a
}

fun makeInteger(i : Int, a : CharArray, lottoNumbers : MutableList<Int>) : Int {
    var tempInt: MutableList<Int> = mutableListOf()
    var check = i
    do {
        tempInt.add(Character.getNumericValue(a[check]))
        check++
    } while (check < a.size && Character.getNumericValue(a[check]) != -1)
    if (tempInt.size == 1)
        lottoNumbers.add(tempInt.get(0))
    if (tempInt.size == 2)
        lottoNumbers.add(tempInt.get(0) * 10 + tempInt.get(1))
    if (tempInt.size > 2)
        throw IllegalArgumentException("[ERROR] 입력한 숫자가 너무 큽니다.")
    return check + 1
}

fun sameCheck(lottoNumbers : MutableList<Int>) : MutableList<Int>{
    var tempNums = lottoNumbers
    tempNums = tempNums.sorted().toMutableList()
    for(i : Int in 0..tempNums.size-2){
        if(tempNums[i] == tempNums[i+1])
            throw IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.")
    }
    return tempNums
}

fun numberSizeCheck(lottoNumbers : MutableList<Int>) : MutableList<Int>{
    for(i : Int in 0..lottoNumbers.size-1){
        if(lottoNumbers[i]>45)
            throw IllegalArgumentException("[ERROR] 45보다 큰 숫자가 있습니다.")
    }
    return lottoNumbers
}

un bonusNumValidCheck(input : String) : Int {
    val bonusNum : Int
    try{
        bonusNum = input.toInt()
    }catch(e : NumberFormatException){
        throw IllegalArgumentException("[ERROR] 제대로 된 형태의 숫자를 입력해 주세요.")
    }
    if(bonusNum<1 || bonusNum>45)
        throw IllegalArgumentException("[ERROR] 45이하의 자연수를 입력해 주세요.")
    return bonusNum
}

fun bonusLottNumCheck(input : Int, lottoNum: MutableList<Int>) : Int{
    for(i : Int in 0..lottoNum.size-1){
        if(lottoNum[i] == input)
            throw IllegalArgumentException("[ERROR] 보너스 숫자가 당첨숫자와 중복됩니다.")
    }
    return input

}

