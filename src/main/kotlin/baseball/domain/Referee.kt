package baseball.domain

import baseball.domain.model.ResultCounter
import baseball.domain.model.ResultState

class Referee(
    private val computerNumbers: List<Int>
) {

    fun checkResult(userNumbers: List<Int>): Pair<ResultState, Map<ResultCounter, Int>> {
        val ball = countBall(userNumbers)
        val strike = countStrike(userNumbers)
        val resultCounter = mapOf(ResultCounter.BALL to ball, ResultCounter.STRIKE to strike)
        return if (ball > 0 && strike > 0) Pair(ResultState.STRIKE_AND_BALL, resultCounter)
        else if (ball > 0) Pair(ResultState.BALL, resultCounter)
        else if (strike > 0) Pair(ResultState.STRIKE, resultCounter)
        else Pair(ResultState.NOTTING, resultCounter)
    }

    private fun countBall(userNumbers: List<Int>): Int {
        return mutableSetOf<Int>().apply {
            userNumbers.forEachIndexed { index, userNumber ->
                val findIndex = computerNumbers.indexOf(userNumber)
                if (findIndex != -1 && findIndex != index) this.add(userNumber)
            }
        }.size
    }

    private fun countStrike(userNumbers: List<Int>): Int {
        return mutableSetOf<Int>().apply {
            userNumbers.forEachIndexed { index, userNumber ->
                val findIndex = computerNumbers.indexOf(userNumber)
                if (findIndex != -1 && findIndex == index) this.add(userNumber)
            }
        }.size
    }

}