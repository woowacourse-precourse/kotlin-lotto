package lotto


class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        var already = arrayOf(0,0,0,0,0,0,0,0,0,0);
        for(i in 0 until 6){
            if(numbers[i] <=0 ) throw IllegalArgumentException()
            already[numbers[i]]++
            if(already[numbers[i]]>=2) throw IllegalArgumentException()
        }
    }
}
