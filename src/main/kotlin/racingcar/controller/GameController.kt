package racingcar.controller

import racingcar.domain.Processor
import racingcar.domain.Scoreboard
import racingcar.validation.InputValidation
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val verifier: InputValidation,
    private val processor: Processor
) {
    lateinit var scoreboard: Scoreboard

    fun userFlow(){
        gameStart()
    }

    private fun gameStart(){
        val userInput = inputView.inputCarNames()
        verifier.checkAccuracyCarNames(userInput)

        val gameCount = inputView.inputNumber()
        verifier.checkAccuracyRacingNumber(gameCount)

    }
}