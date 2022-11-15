package lotto

class WinningCount{
    fun WinningNumbers(total_numbers:MutableList<List<Int>>,lotto_numbers_list:MutableList<Int>,bonus:Int): MutableMap<Int, Int> {
        val winning_numbers_count= mutableMapOf<Int,Int>(5000 to 0, 50000 to 0, 1500000 to 0, 30000000 to 0, 2000000000 to 0)

        for(elem in total_numbers){
            val winning_numbers=lotto_numbers_list.toSet().intersect(elem)
            ThreeNumbers(winning_numbers,winning_numbers_count)
            FourNumbers(winning_numbers,winning_numbers_count)
            FiveNumbersAndBonus(winning_numbers,winning_numbers_count,bonus,elem)
            FiveNumbers(winning_numbers,winning_numbers_count,bonus,elem)
            SixNumbers(winning_numbers,winning_numbers_count)
        }
        return winning_numbers_count
    }

    fun ThreeNumbers(winning_numbers:Set<Int>,winning_numbers_count:MutableMap<Int,Int>){
        if(winning_numbers.size==3){
            winning_numbers_count[5000] = winning_numbers_count[5000]!! + 1
            return
        }
    }

    fun FourNumbers(winning_numbers:Set<Int>,winning_numbers_count:MutableMap<Int,Int>){
        if(winning_numbers.size==4){
            winning_numbers_count[50000] = winning_numbers_count[50000]!! + 1
            return
        }
    }

    fun FiveNumbersAndBonus(winning_numbers:Set<Int>,winning_numbers_count:MutableMap<Int,Int>,bonus: Int,elem:List<Int>){
        if(winning_numbers.size==5 && bonus in elem){
            winning_numbers_count[30000000] = winning_numbers_count[30000000]!! + 1
            return
        }
    }

    fun FiveNumbers(winning_numbers:Set<Int>,winning_numbers_count:MutableMap<Int,Int>,bonus: Int,elem:List<Int>){
        if(winning_numbers.size==5 && bonus !in elem){
            winning_numbers_count[1500000] = winning_numbers_count[1500000]!! + 1
            return
        }
    }

    fun SixNumbers(winning_numbers:Set<Int>,winning_numbers_count:MutableMap<Int,Int>){
        if(winning_numbers.size==6){
            winning_numbers_count[2000000000] = winning_numbers_count[2000000000]!! + 1
            return
        }
    }
    fun PrintWinningCount(winning_numbers_count:MutableMap<Int,Int>){
        println("3개 일치 (5,000원) - ${winning_numbers_count[5000]}개")
        println("4개 일치 (50,000원) - ${winning_numbers_count[50000]}개")
        println("5개 일치 (1,500,000원) - ${winning_numbers_count[1500000]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winning_numbers_count[30000000]}개")
        println("6개 일치 (2,000,000,000원) - ${winning_numbers_count[2000000000]}개")
    }
}