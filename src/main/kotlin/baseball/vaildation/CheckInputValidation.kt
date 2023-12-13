package baseball.vaildation

import baseball.util.Error
import baseball.util.GameRule
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsValidNumber(userInput: String) {
        require(isNumber(userInput) && isSingleDigit(userInput)) {
            Error.NOT_VALID_NUMBER
        }
    }

    fun checkRestartNumber(userInput: String) {
        require(isNumber(userInput) && isRestartNumber(userInput.toInt())){
            Error.NOT_VALID_RESTART
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

    private fun isSingleDigit(userInput: String): Boolean = userInput.toInt() in GameRule.MIN_NUMBER .. GameRule.MAX_NUMBER

    private fun isRestartNumber(userInput: Int): Boolean = userInput in GameRule.RESTART_OK_CODE .. GameRule.RESTART_NO_CODE
}