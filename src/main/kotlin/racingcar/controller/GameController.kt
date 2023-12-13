package racingcar.controller

import racingcar.domain.Processor
import racingcar.domain.Scoreboard
import racingcar.domain.model.CarState
import racingcar.util.Form
import racingcar.validation.InputValidation
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val verifier: InputValidation,
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
        println()
        outputView.startResult()

        while(scoreboard.checkCount()){
            scoreboard.progressRound()
            roundResult()
            println()
        }
    }

    private fun gameResult(){
        val winners = scoreboard.makeWinningDocument()
        outputView.finalResult(winners)
    }

    private fun makeCars(userInput: String): Map<String, Int> {
        return userInput.split(Form.SEPARATOR).associateWith { 0 }
    }

    private fun initScoreBoard(userInput: String, gameCount: String) {
        scoreboard = Scoreboard(
            processor = Processor(),
            cars = makeCars(userInput).toMutableMap(),
            maxRound = gameCount.toInt()
        )
    }

    private fun roundResult(){
        scoreboard.getCarNames().forEach { name ->
            scoreboard.getMatchCount(name)?.let { outputView.carProgressResult(name, it) }
        }
    }

}