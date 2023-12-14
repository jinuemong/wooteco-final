package lotto

import lotto.controller.MainController
import lotto.validation.InputValidation
import lotto.validation.LottoValidation
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    try{
        val controller = MainController(
            inputView = InputView(),
            outputView = OutputView(),
            inputVerifier = InputValidation(),
            lottoVerifier = LottoValidation()
        )
        controller.userFlow()
    } catch (e: IllegalArgumentException){
        println(e.message)
    }
}