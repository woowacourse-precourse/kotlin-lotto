package lotto.domain

import lotto.constants.Constant

enum class Reward(val hit: Int, val prize: Int, val isBonus: Boolean) {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false)
}

fun getReward(
    lottoWrapper: LottoWrapper,
    winningLotto: Lotto,
    bonusNumber: Int
): MutableList<Reward> {
    val rewards = mutableListOf<Reward>()
    for (index in Constant.START_INDEX until lottoWrapper.size()) {
        var result = compare(lottoWrapper.get(index), winningLotto, bonusNumber)
        rewards.add(calculateReward(result))
    }
    return rewards
}

// 해당 로또와 당첨 번호를 비교하여 맞은 개수를 구하는 메소드
fun compare(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
    var hit = 0
    var isBonus = false
    val numbers = lotto.getNumbers()
    val winningNumbers = winningLotto.getNumbers()
    for (number in numbers) {
        if (winningNumbers.contains(number)) {
            hit++
        }
    }
    if (numbers.contains(bonusNumber)) {
        isBonus = true
    }
    return Pair(hit, isBonus)
}

// 해당 로또의 맞은 개수, 보너스 유무를 가지고 등수를 계산하는 메소드
fun calculateReward(result: Pair<Int, Boolean>): Reward {
    when (result.first) {
        Reward.FIRST.hit -> return Reward.FIRST
        Reward.FOURTH.hit -> return Reward.FOURTH
        Reward.FIFTH.hit -> return Reward.FIFTH
    }
    if (result.first == Reward.SECOND.hit && result.second) {
        return Reward.SECOND
    }
    if (result.first == Reward.THIRD.hit && !result.second) {
        return Reward.THIRD
    }
    return Reward.MISS
}