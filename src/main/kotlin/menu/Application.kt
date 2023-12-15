package menu

import menu.controller.MenuController
import menu.domain.CategoryDiscriminator
import menu.domain.MenuSelector
import menu.domain.ValidityChecker
import menu.view.InputView
import menu.view.OutputView

fun main() {

    val menuController = MenuController(
        inputView = InputView(),
        outputView = OutputView(),
        inputVerifier = ValidityChecker(),
        menuSelector = MenuSelector(),
        categoryVerifier = CategoryDiscriminator()
    )
    menuController.userFlow()

}