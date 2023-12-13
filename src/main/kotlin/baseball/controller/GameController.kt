package baseball.controller

import baseball.domain.Computer
import baseball.domain.Referee
import baseball.domain.model.ResultState
import baseball.util.GameRule
import baseball.vaildation.CheckInputValidation
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val verifier: CheckInputValidation
) {
    private lateinit var computer: Computer
    private lateinit var referee: Referee

    fun userFlow() {
        gameStart()
        gameProgress()
    }

    private fun gameStart() {
        outputView.enterGame()
        gameAssignment()
    }

    private fun gameProgress() {
        while (true) {
            val userNumber = makeUserNumbers()
            val (resultState, ball, strike) = referee.checkResult(userNumber)

            when (resultState) {
                ResultState.STRIKE -> {
                    outputView.resultStrike(strike)
                    if (checkEndGame(strike)) break
                }
                ResultState.BALL -> outputView.resultBall(ball)
                ResultState.STRIKE_AND_BALL -> outputView.resultBailAndStrike(ball, strike)
                ResultState.NOTTING -> outputView.resultNotting()
            }

        }
        checkRestart()
    }

    private fun checkRestart() {
        inputView.enterGameRestart().let {number ->
            verifier.checkRestartNumber(number)
            if (number.toInt() == 1) gameProgress()
        }
    }


    private fun gameAssignment() {
        computer = Computer()
        referee = Referee(computer.getComputerNumbers())
    }

    private fun makeUserNumbers(): List<Int> {
        return mutableListOf<Int>().apply {
            inputView.enterNumber().let { newNumber ->
                verifier.checkIsValidNumber(newNumber)
                add(newNumber.toInt())
            }
        }
    }

    private fun checkEndGame(result: Int): Boolean = result == GameRule.END_STRIKE_COUNT


}