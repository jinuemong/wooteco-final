package racingcar


import racingcar.controller.GameController
import racingcar.domain.Processor
import racingcar.validation.InputValidation
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    val gameController = GameController(
        inputView = InputView(),
        outputView = OutputView(),
        verifier = InputValidation()
    )
    gameController.userFlow()

}