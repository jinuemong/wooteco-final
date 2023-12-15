package menu.domain

import menu.domain.utils.Rule
import java.lang.NumberFormatException

class ValidityChecker {

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
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

    private
}