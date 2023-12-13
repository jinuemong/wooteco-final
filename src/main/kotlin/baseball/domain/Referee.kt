package baseball.domain

import baseball.domain.model.ResultCounter
import baseball.domain.model.ResultState

class Referee(
    private val computerNumbers: List<Int>
) {

    fun checkResult(userNumbers: List<Int>): Triple<ResultState, Int, Int> {
        val ball = countBall(userNumbers)
        val strike = countStrike(userNumbers)
        return if (ball > 0 && strike > 0) Triple(ResultState.STRIKE_AND_BALL, ball, strike)
        else if (ball > 0) Triple(ResultState.BALL, ball, strike)
        else if (strike > 0) Triple(ResultState.STRIKE, ball, strike)
        else Triple(ResultState.NOTTING, ball, strike)
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