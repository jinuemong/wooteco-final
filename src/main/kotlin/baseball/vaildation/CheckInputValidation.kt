package baseball.vaildation

import baseball.util.Error
import java.lang.NumberFormatException

class CheckInputValidation {

    private fun checkIsValidNumber(userInput: String) {
        require(isNumber(userInput) && isSingleDigit(userInput)) {
            Error.NOT_VALID_NUMBER
        }
    }

    private fun isNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun isSingleDigit(userInput: String): Boolean = userInput.toInt() in 1..9
}