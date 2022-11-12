package lotto

enum class Rank(val rank: Int, val prizeMoney: Int) {
    First(1,2000000000), Second(2, 30000000),
    Third(3, 1500000), Fourth(4, 50000),
    Fifth(5, 5000), None(0,0)
}