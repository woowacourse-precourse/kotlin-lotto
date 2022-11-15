package lotto.Model

enum class Rank(val prizeMoney: Int, val rankNum: Int) {
    First(2000000000, 1), Second(30000000, 2),
    Third(1500000, 3), Fourth(50000, 4),
    Fifth(5000, 5), None(0, 0);
}