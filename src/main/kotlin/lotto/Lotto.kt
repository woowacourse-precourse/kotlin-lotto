package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        var sizecheck = numbers.distinct().size
        require(numbers.size == 6)
        require(sizecheck == 6)

    }
    fun calculater (a:IntArray) : Int {
        var money = 0
        var rank = IntArray(5,)
        for(item in a){ when(item){
            3 -> { rank[0] += 1
                money+=5000 }
            4 -> { rank[1] += 1
                money+=50000 }
            5 -> { rank[2] += 1
                money+=1500000 }
            6 -> { rank[4] += 1
                money+=30000000 }
            15 -> { rank[3] += 1
                money+=2000000000 } } }
        printwin(rank)
        return money }
    fun printwin (a:IntArray) {
        println("3개 일치 (5,000원) - ${a[0]}개")
        println("4개 일치 (50,000원) - ${a[1]}개")
        println("5개 일치 (1,500,000원) - ${a[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${a[3]}개")
        println("6개 일치 (2,000,000,000원) - ${a[4]}개")
    }
}


