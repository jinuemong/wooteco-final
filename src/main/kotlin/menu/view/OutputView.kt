package menu.view

import menu.domain.model.Category
import menu.domain.model.MenuDay
import menu.domain.utils.Message

class OutputView {

    fun outputStart() {
        println(Message.START)
        println()
    }

    fun outputResult() {
        println()
        println(Message.RESULT)
        println(Message.MSG_START_DAY + MenuDay.getMenuDayMessage() + Message.UNIT_END)
    }

    fun outputCategory(category: List<Category>) {
        val categoryMessage = category.joinToString(Message.SEPARATOR) { it.getName() }
        println(Message.MSG_START_CATEGORY + categoryMessage + Message.UNIT_END)
    }

    fun outputCoachMenu(name: String, menus: List<String>) {
        val menuMessage = menus.joinToString(Message.SEPARATOR)
        println(Message.MSG_START_COACH.format(name) + menuMessage + Message.UNIT_END)
    }

    fun outputEnd() {
        println()
        println(Message.END_RESULT)
    }

}