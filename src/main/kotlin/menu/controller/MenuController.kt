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
    private val menuSelector: MenuSelector,
    private var coaches: MutableList<Coach> = mutableListOf()
) {

    fun userFlow() {
        makeCoach()
        saveForbiddenFood()
        categorySelect()
        menuSelect()
        result()
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

    private fun saveForbiddenFood() {
        coaches.forEach { coach ->
            while (true) {
                try {
                    val userInput = inputView.requireCoachForbiddenMenu(coach.getCoachName())
                    inputVerifier.checkInputMenu(userInput)

                    coach.saveForbiddenFood(userInput)
                    break
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }
    }

    private fun categorySelect() {
        while (!categoryVerifier.checkIsEnoughCategoryCount()) {
            val newCategory = menuSelector.selectCategory()
            if (categoryVerifier.checkCategory(newCategory))
                categoryVerifier.addCategory(newCategory)
        }
    }

    private fun menuSelect() {
        val menuCategory = categoryVerifier.getCategory()
        coaches.forEach { coach ->
            menuCategory.forEach { category ->
                while (true) {
                    val newMenu = menuSelector.selectCategoryMenu(category)
                    if (!coach.checkIsPrevFeed(newMenu) && !coach.checkIsForbiddenFood(newMenu)) {
                        coach.saveMenu(newMenu)
                        break
                    }
                }
            }
        }
    }

    private fun result() {
        outputView.outputResult()
        outputView.outputCategory(categoryVerifier.getCategory())
        coaches.forEach { coach ->
            outputView.outputCoachMenu(
                coach.getCoachName(),
                coach.getCoachMenu()
            )
        }
        outputView.outputEnd()
    }


    private fun initCoach(userInput: List<String>) {
        userInput.forEach { name ->
            coaches.add(Coach(name))
        }
    }
}