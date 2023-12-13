package baseball.view

import baseball.util.Message

class OutputView {

    fun enterGame() = println(Message.GAME_START)

    fun resultBailAndStrike(ball: Int, strike: Int) = println(Message.RESULT_STRIKE_AND_BALL.format(ball, strike))

    fun resultBall(ball: Int) = println(Message.RESULT_ONLY_BALL.format(ball))

    fun resultStrike(strike: Int) = println(Message.RESULT_ONLY_STRIKE.format(strike))

    fun resultNotting() = println(Message.RESULT_NOTTING)

    fun endGame() = println(Message.GAME_END)
}