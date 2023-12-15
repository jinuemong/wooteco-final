package christmas.validation


import christmas.domain.model.MenuInfo
import christmas.utils.Error
import christmas.utils.Form
import christmas.utils.Rule
import java.lang.NumberFormatException

class UserValidation {

    fun checkUserDate(userInput: String) {
        require(checkIsNumber(userInput) && checkIsDate(userInput.toInt())) {
            Error.INCORRECT_DATE
        }
    }

    fun checkMenus(
        menuNames: List<String>,
        menuNumbers: List<String>

    ) {

        require(checkMatchNameAndNumberCount(menuNames, menuNumbers)) {
            Error.WRONG_MENU_FORM
        }

        require(checkIsMenu(menuNames)) {
            Error.WRONG_MENU
        }

        require(checkMenuRange(menuNumbers.size)) {
            Error.WRONG_MENU_COUNT
        }

        require(checkMenuDuplicate(menuNames)) {
            Error.DUPLICATE_MENU
        }
    }

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsDate(userInput: Int): Boolean {
        return userInput in Rule.START_DATE..Rule.END_DATE
    }

    private fun checkIsMenu(menuNames: List<String>): Boolean {
        try {
            menuNames.forEach {
                MenuInfo.getMenuInfo(it)
            }
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }

    private fun checkMenuDuplicate(menuNames: List<String>): Boolean {
        return menuNames.size == menuNames.toSet().size
    }

    private fun checkMenuRange(count: Int): Boolean {
        return count in 0..Rule.MAX_ORDER_COUNT
    }

    private fun checkMatchNameAndNumberCount(
        menuNames: List<String>,
        menuNumbers: List<String>
    ): Boolean = menuNames.size == menuNumbers.size

    private fun checkPair(data: String): Boolean {
        return data.split(Form.ORDER_SEPARATOR).size == 2
    }


}