package racingcar.validation

import java.lang.NumberFormatException

class InputValidation {


    private fun isNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun isPositive(userInput: Int): Boolean = userInput > 0
}