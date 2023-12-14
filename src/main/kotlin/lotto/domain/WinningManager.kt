package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.ResultState
import lotto.util.Rule

class WinningManager(
    private val winningNumbers: Set<Int>,
    private val bonusNumber: Int
) {
    private val lottoResult: MutableMap<ResultState, Int> = mutableMapOf()

    init {
        ResultState.entries.forEach { lottoResult[it] = 0 }
    }

    fun confirmWinning(numbers: Set<Int>) {
        val remainingNumbers = checkMatchNum(numbers)
        val winningCount = getWinningCount(remainingNumbers)
        val bonus = checkBonus(remainingNumbers)
        ResultState.getResult(winningCount, bonus)?.let { resultState ->
            lottoResult[resultState] = (lottoResult[resultState] ?: 0) + 1
        }
    }

    fun getLottoResults(): List<Pair<String,Int>>{
        return lottoResult.map { (resultState,count) ->
            resultState.getMessage() to count
        }
    }


    fun getTotalPrice(): Int {
        return lottoResult.map { (resultState, count) ->
            resultState.getPrice(count)
        }.sum()
    }

    private fun getWinningCount(remainingNumbers: Set<Int>) = Rule.LOTTO_COUNT - remainingNumbers.size

    private fun checkMatchNum(numbers: Set<Int>): Set<Int> = numbers - winningNumbers


    private fun checkBonus(remainingNumbers: Set<Int>): Boolean = remainingNumbers.contains(bonusNumber)


}