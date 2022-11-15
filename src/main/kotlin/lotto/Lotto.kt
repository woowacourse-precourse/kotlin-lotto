package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkRank(winningNumbers: ArrayList<Int>): Int {
        return numberOfContains(winningNumbers, numbers)
    }

    fun isContainNumber(number: Int, winningNumbers: ArrayList<Int>): Boolean {
        return numberOfContains(winningNumbers, numbers) == 4 && numbers.contains(number)
    }

    fun printNumbers() {
        var str = "["

        for(number in numbers) {
            str += "$number, "
        }

        str = str.substring(0, str.length - 2)
        str += "]"
        println(str)
    }
}

fun numberOfContains(winningNumbers: ArrayList<Int>, numbers: List<Int>): Int {
    val compareSet = HashSet<Int>()
    compareSet.addAll(numbers)

    var count = 0
    for(number in winningNumbers) {
        if(compareSet.contains(number)) {
            count++
        }
    }

    return count
}

