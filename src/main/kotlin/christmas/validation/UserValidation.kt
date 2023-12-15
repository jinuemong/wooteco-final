package christmas.validation


import christmas.utils.Rule
import java.lang.NumberFormatException

class UserValidation {

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsDate(userInput: Int): Boolean {
        return userInput in Rule.START_DATE.. Rule.END_DATE
    }


}