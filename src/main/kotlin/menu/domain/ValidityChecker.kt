package menu.domain

import menu.domain.model.Category
import menu.domain.utils.Error
import menu.domain.utils.Rule

class ValidityChecker {

    fun checkInputCoachNumber(userInput: List<String>){
        require(checkMinCoachNum(userInput.size)){
            Error.FEWER_COACHES
        }

        require(checkMaxCoachNum(userInput.size)){
            Error.LARGE_COACHES
        }
    }

    fun checkInputCoachName(userInput: List<String>){
        userInput.forEach { name ->
            require(checkMinName(name)){
                Error.FEWER_COACH_NAME
            }

            require(checkMaxName(name)){
                Error.LARGE_COACH_NAME
            }

            require(checkNameValid(name)){
                Error.INACCURATE_COACH_NAME
            }
        }
    }

    fun checkInputMenu(userInput: List<String>){
        userInput.forEach {menu ->
            try {
                Category.getCategoryFromName(menu)
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    private fun checkMinName(name: String) : Boolean{
        return name.length >= Rule.MIN_NAME
    }

    private fun checkMaxName(name: String) : Boolean {
        return name.length <= Rule.MAX_NAME
    }

    private fun checkNameValid(name: String ): Boolean{
        return name.matches(Regex(Rule.NAME_RULE))
    }

    private fun checkMinCoachNum(count: Int): Boolean{
        return count >= Rule.MIN_COACH_NUM
    }

    private fun checkMaxCoachNum(count: Int): Boolean{
        return count <= Rule.MAX_COACH_NUM
    }

}