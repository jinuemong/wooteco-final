package christmas.validation


import christmas.domain.model.MenuInfo
import christmas.utils.Form
import christmas.utils.Rule
import java.lang.NumberFormatException

class UserValidation {

    fun checkUserDate(userInput: String){
        require(checkIsNumber(userInput) && checkIsDate(userInput.toInt()))
    }

    fun checkMenus(userInput: String){
        require(userInput.isNotEmpty())

        var menuCount = 0
        userInput.split(Form.ORDER_SEPARATOR).forEach { pairMenu ->

            require(checkPair(pairMenu))

            val (menu,num) = pairMenu.split(Form.MENU_SEPARATOR)
            require(checkIsMenu(menu))
            require(checkIsNumber(num) && checkMenuRange(num.toInt()))

            menuCount+= num.toInt()
            require(checkMenuRange(menuCount))
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


    private fun checkIsMenu(name: String): Boolean{
        return try {
            MenuInfo.getMenuInfo(name)
            true
        } catch (e: IllegalArgumentException){
            false
        }
    }

    private fun checkMenuRange(count: Int): Boolean{
        return count in 0..Rule.MAX_ORDER_COUNT
    }

    private fun checkPair(data: String): Boolean{
        return data.split(Form.ORDER_SEPARATOR).size == 2
    }


}