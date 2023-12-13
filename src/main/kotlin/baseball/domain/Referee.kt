package baseball.domain

import baseball.domain.model.ResultState

class Referee(
    private val computerNumbers: List<Int>
) {

    fun checkResult(userNumbers: List<Int>): Triple<ResultState, Int, Int> {
        val (ball, strike) = countResult(userNumbers)
        return if (ball == 0 && strike == 0) Triple(ResultState.NOTTING, ball, strike)
        else if (ball == 0) Triple(ResultState.STRIKE, ball, strike)
        else if (strike == 0) Triple(ResultState.BALL, ball, strike)
        else Triple(ResultState.STRIKE_AND_BALL, ball, strike)
    }

    private fun countResult(userNumbers: List<Int>): Pair<Int, Int> {
        var ball = 0
        var strike = 0

        userNumbers.forEachIndexed { index, userNumber ->
            if (countStrike(index, userNumber)) strike++
            else if (countBall(userNumber)) ball++
        }

        return Pair(ball, strike)
    }

    private fun countStrike(index: Int, userNumber: Int): Boolean = userNumber == computerNumbers[index]

    private fun countBall(userNumber: Int): Boolean = computerNumbers.contains(userNumber)

}