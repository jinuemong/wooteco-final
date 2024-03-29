package baseball.vaildation

import baseball.util.Error
import baseball.util.GameRule
import java.lang.NumberFormatException

class CheckInputValidation {

    fun checkIsValidNumber(userInput: String) {

        require(isValidNumberSize(userInput)) {
            println(Error.NOT_NUMBER_COUNT)
        }

        require(isNumber(userInput) && isSingleDigit(userInput)) {
            println(Error.NOT_VALID_NUMBER)
        }
    }

    fun checkRestartNumber(userInput: String) {
        require(isRestartNumber(userInput)) {
            println(Error.NOT_VALID_RESTART)
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

    private fun isSingleDigit(userInput: String): Boolean {
        userInput.forEach { number ->
            if (number.digitToInt() !in GameRule.MIN_NUMBER..GameRule.MAX_NUMBER) return false
        }
        return true
    }

    private fun isRestartNumber(userInput: String): Boolean =
        userInput == GameRule.RESTART_OK_CODE || userInput == GameRule.RESTART_NO_CODE

    private fun isValidNumberSize(userInput: String): Boolean = userInput.length <= GameRule.NUMBER_SIZE

}