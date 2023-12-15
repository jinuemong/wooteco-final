package menu.controller

import menu.domain.CategoryDiscriminator
import menu.domain.MenuSelector
import menu.domain.ValidityChecker
import menu.domain.model.Coach
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputVerifier: ValidityChecker,
    private val categoryVerifier: CategoryDiscriminator,
    private var coaches: MutableList<Coach> = mutableListOf()
) {
    private lateinit var menuSelector: MenuSelector

    fun userFlow() {
        makeCoach()
        saveForbiddenFood()
    }

    private fun makeCoach() {
        outputView.outputStart()

        while (coaches.isEmpty()) {
            try {
                val userInput = inputView.requireNames()
                inputVerifier.checkInputCoachNumber(userInput)
                inputVerifier.checkInputCoachName(userInput)

                initCoach(userInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun saveForbiddenFood(){

    }


    private fun initCoach(userInput: List<String>){
        userInput.forEach {name ->
            coaches.add(Coach(name))
        }
    }
}