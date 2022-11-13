package lotto

enum class Rank(val prizeMoney: Int) {
    First(2000000000), Second(30000000),
    Third(1500000), Fourth(50000),
    Fifth(5000), None(0);
}