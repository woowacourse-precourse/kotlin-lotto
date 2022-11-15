package lotto

class Compare {

    fun comparenumber(a:MutableList<List<Int>> , b:IntArray , c:Int) : IntArray {
        var countunion = IntArray(a.size)
        var bcp = 0
        for (i in 0..a.size-1) {
            var cpn1 = mutableListOf<Int>()
            var cpn2 = mutableListOf<Int>()
            for (j in 0..5) {
                cpn1.add(comparenumber1(a,b,i,j))
                cpn2.add(comparenumber2(a,b,i,j))
                bcp = bonuscompare(a,b,c,i,j) }
            countunion[i]+=cpn1.sum()
            countunion[i]+=cpn2.sum()
            if (bcp > 0 && countunion[i] == 5) {
                countunion[i]+=10
            } }
        return countunion }

    fun comparenumber1(a:MutableList<List<Int>> , b:IntArray , d:Int , e:Int) : Int {
        var firstcount = 0
        if (b[0] == a[d][e])
        {
            firstcount+=1
        }
        if (b[1] == a[d][e])
        {
            firstcount+=1
        }
        if (b[2] == a[d][e])
        {
            firstcount+=1
        }
        return firstcount
    }

    fun comparenumber2(a:MutableList<List<Int>> , b:IntArray , d:Int , e:Int) : Int {
        var secondcount = 0
        if (b[3] == a[d][e])
        {
            secondcount+=1
        }
        if (b[4] == a[d][e])
        {
            secondcount+=1
        }
        if (b[5] == a[d][e])
        {
            secondcount+=1
        }
        return secondcount
    }
}