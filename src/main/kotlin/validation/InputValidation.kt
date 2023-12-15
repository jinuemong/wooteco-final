package validation

import christmas.utils.Rule
import java.lang.NumberFormatException

class InputValidation {

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsDate(date: Int): Boolean{
        return date in Rule.START_DATE .. Rule.END_DATE
    }

}