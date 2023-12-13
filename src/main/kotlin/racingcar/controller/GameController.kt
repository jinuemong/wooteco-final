package racingcar.controller

import racingcar.domain.Processor
import racingcar.domain.Scoreboard
import racingcar.util.Form
import racingcar.validation.InputValidation
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val verifier: InputValidation,
    private val processor: Processor
) {
    private lateinit var scoreboard: Scoreboard

    fun userFlow() {
        gameStart()
        playGame()
        gameResult()
    }

    private fun gameStart() {
        val userInput = inputView.inputCarNames()
        verifier.checkAccuracyCarNames(userInput)

        val gameCount = inputView.inputNumber()
        verifier.checkAccuracyRacingNumber(gameCount)

        initScoreBoard(userInput, gameCount)

    }

    private fun playGame(){

    }

    private fun gameResult(){

    }

    private fun makeCars(userInput: String): Map<String, Int> {
        return userInput.split(Form.SEPARATOR).associateWith { 0 }
    }

    private fun initScoreBoard(userInput: String, gameCount: String) {
        scoreboard = Scoreboard(makeCars(userInput), gameCount.toInt())
    }

}